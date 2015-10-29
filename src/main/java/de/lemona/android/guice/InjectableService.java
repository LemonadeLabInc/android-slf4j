package de.lemona.android.guice;

import java.util.Arrays;

import com.google.inject.Module;

import android.app.Service;

public abstract class InjectableService extends Service {

    static { Injection.init(); }

    private final Iterable<? extends Module> modules;

    protected InjectableService(Module... modules) {
        this.modules = modules == null ? null : Arrays.asList(modules);
    }

    protected InjectableService(Iterable<? extends Module> modules) {
        this.modules = modules;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Injection.createInjector(this, modules);
    }
}
