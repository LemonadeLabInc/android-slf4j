package de.lemona.android.guice;

import java.util.Arrays;

import com.google.inject.Module;

import android.app.Service;

public abstract class InjectableService extends Service {

    private volatile Injector injector = null;
    private final Iterable<? extends Module> modules;

    protected InjectableService(Module... modules) {
        this.modules = modules == null ? null : Arrays.asList(modules);
    }

    protected InjectableService(Iterable<? extends Module> modules) {
        this.modules = modules;
    }

    protected Injector getInjector() {
        if (injector == null) throw new IllegalStateException("Injector unavailable");
        return injector;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (this.injector == null) {
            this.injector = Injection.createInjector(this, modules);
            this.injector.injectMembers(this);
        }
    }

}
