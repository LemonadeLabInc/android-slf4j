package de.lemona.android.guice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.ProvisionException;
import com.google.inject.internal.util.$FinalizableReferenceQueue;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public final class Injection {

    private Injection() {
        throw new IllegalStateException("Do not construct");
    }

    /* ========================================================================================== */

    // Filter annoying log for which we can do nothing about...
    private static boolean initialized = false;
    static final void init() {
        if (initialized) return;
        initialized = true;

        Logger.getLogger($FinalizableReferenceQueue.class.getName()).setFilter(new Filter() {
            @Override public boolean isLoggable(LogRecord record) {
                if (record.getMessage().startsWith("Could not load Finalizer")) return false;
                return true;
            }
        });
    }

    static { Injection.init(); }

    /* ========================================================================================== */

    public static Injector createInjector(Context context) {
        return createInjector(context, (Iterable<Module>) null);
    }

    public static Injector createInjector(Context context, Module... modules) {
        if ((modules == null) || (modules.length == 0)) return createInjector(context, (Iterable<Module>) null);
        return createInjector(context, Arrays.asList(modules));
    }

    public static Injector createInjector(Context context, Iterable<? extends Module> modules) {

        // A simple list of all modules we need to inject
        final List<Module> parentModule = new ArrayList<>();
        parentModule.add(new SystemModule());

        if (context instanceof Activity) {
            parentModule.add(new ActivityModule((Activity) context));
        } else if (context instanceof Service) {
            parentModule.add(new ServiceModule((Service) context));
        }

        final Injector applicationInjector = applicationInjector(context);
        final Injector parentInjector = applicationInjector.createChildInjector(parentModule);
        return modules == null ? parentInjector : parentInjector.createChildInjector(modules);
    }

    /* ========================================================================================== */

    private static final Map<Context, Injector> applicationInjectors = new IdentityHashMap<>();

    private static final int FLAGS = PackageManager.GET_ACTIVITIES
                                   | PackageManager.GET_INSTRUMENTATION
                                   | PackageManager.GET_PROVIDERS
                                   | PackageManager.GET_RECEIVERS
                                   | PackageManager.GET_SERVICES;

    private static Injector applicationInjector(Context childContext) {
        final Context context = childContext.getApplicationContext();
        final Injector existing = applicationInjectors.get(context);
        if (existing != null) return existing;

        synchronized (applicationInjectors) {
            final Injector previous = applicationInjectors.get(context);
            if (previous != null) return existing;

            final String packageName = context.getPackageName();
            final PackageManager packageManager = context.getPackageManager();
            final PackageInfo packageInfo;
            try {
                packageInfo = packageManager.getPackageInfo(packageName, FLAGS);
            } catch (final Exception exception) {
                throw new ProvisionException("Unable to get package info for " + packageName, exception);
            }

            final Set<String> componentClasses = new HashSet<>();
            findComponents(componentClasses, packageInfo.activities);
            findComponents(componentClasses, packageInfo.instrumentation);
            findComponents(componentClasses, packageInfo.providers);
            findComponents(componentClasses, packageInfo.receivers);
            findComponents(componentClasses, packageInfo.services);

            Log.i("TAG", "Found " + componentClasses + " component classes");

            final ClassLoader classLoader = context.getClassLoader();

            final Set<Class<? extends Module>> moduleClasses = new HashSet<>();
            for (final String className: componentClasses) {
                findModules(classLoader, className, moduleClasses);
            }

            Log.i("TAG", "Found " + moduleClasses + " module classes");

            final List<Module> modules = new ArrayList<>();
            modules.add(new ApplicationModule(context));

            for (final Class<? extends Module> moduleClass: moduleClasses) try {
                modules.add(moduleClass.newInstance());
            } catch (final Exception exception) {
                throw new ProvisionException("Unable to instantiate module " + moduleClass.getName(), exception);
            }

            Log.i("TAG", "Found " + modules + " modules");

            final Injector injector = Guice.createInjector(modules);
            applicationInjectors.put(context, injector);
            return injector;
        }
    }

    private static void findComponents(Collection<String> classNames, PackageItemInfo[] infos) {
        Log.i("TAG", "Processing " + (infos == null ? -1 : infos.length) + " info items");
        if (infos == null) return;
        for (final PackageItemInfo info: infos) {
            classNames.add(info.name.startsWith(".") ? info.packageName + info.name : info.name);
        }
    }

    private static void findModules(ClassLoader classLoader, String className, Collection<Class<? extends Module>> moduleClasses) {
        final Class<?> componentClass;

        try {
            componentClass = classLoader.loadClass(className);
        } catch (final Exception exception) {
            throw new ProvisionException("Unable to load component class " + className, exception);
        }

        Log.i("TAG", "Component class is " + className + ": " + componentClass.isAnnotationPresent(Modules.class));

        if (componentClass.isAnnotationPresent(Modules.class)) {
            final Modules annotation = componentClass.getAnnotation(Modules.class);
            for (final Class<? extends Module> moduleClass: annotation.value()) {
                moduleClasses.add(moduleClass);
            }
        }
    }
}
