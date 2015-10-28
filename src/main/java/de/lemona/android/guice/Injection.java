package de.lemona.android.guice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.internal.util.$FinalizableReferenceQueue;

import android.app.Activity;
import android.app.Service;
import android.content.Context;

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

    public static com.google.inject.Injector createInjector(Context context) {
        return createInjector(context, (Iterable<Module>) null);
    }

    public static com.google.inject.Injector createInjector(Context context, Module... modules) {
        if ((modules == null) || (modules.length == 0)) return createInjector(context, (Iterable<Module>) null);
        return createInjector(context, Arrays.asList(modules));
    }

    public static com.google.inject.Injector createInjector(Context context, Iterable<? extends Module> modules) {

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
}
