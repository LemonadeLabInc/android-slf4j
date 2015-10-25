package de.lemona.android.guice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Module;

import android.app.Activity;
import android.app.Service;
import android.content.Context;

public final class Injection {

    private Injection() {
        throw new IllegalStateException("Do not construct");
    }

    /* ========================================================================================== */

    public static com.google.inject.Injector createGuiceInjector(Context context) {
        return createGuiceInjector(context, (Iterable<Module>) null);
    }

    public static com.google.inject.Injector createGuiceInjector(Context context, Module... modules) {
        if ((modules == null) || (modules.length == 0)) return createGuiceInjector(context, (Iterable<Module>) null);
        return createGuiceInjector(context, Arrays.asList(modules));
    }

    public static com.google.inject.Injector createGuiceInjector(Context context, Iterable<? extends Module> modules) {

        // A simple list of all modules we need to inject
        final List<Module> parent = new ArrayList<>();
        parent.add(new SystemModule());

        if (context instanceof Activity) {
            parent.add(new ActivityModule((Activity) context));
        } else if (context instanceof Service) {
            parent.add(new ServiceModule((Service) context));
        } else {
            parent.add(new ContextModule(context));
        }

        // If we have no extra modules, the parent injector will suffice, otherwise override with child
        if ((modules == null) || ((modules instanceof Collection) && ((Collection<?>) modules).isEmpty())) {
            return Guice.createInjector(parent);
        } else {
            return Guice.createInjector(parent).createChildInjector(modules);
        }
    }

    /* ========================================================================================== */

    public static Injector createInjector(Context context) {
        return new InjectorWrapper(createGuiceInjector(context));
    }

    public static Injector createInjector(Context context, Module... modules) {
        return new InjectorWrapper(createGuiceInjector(context, modules));
    }

    public static Injector createInjector(Context context, Iterable<? extends Module> modules) {
        return new InjectorWrapper(createGuiceInjector(context, modules));
    }
}
