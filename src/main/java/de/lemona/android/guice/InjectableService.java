package de.lemona.android.guice;

import com.google.inject.Module;

import android.app.Service;

public abstract class InjectableService extends Service {

    protected final Injector injector;

    protected InjectableService(Module... modules) {
        this.injector = Injection.createInjector(this, modules);
    }

    protected InjectableService(Iterable<? extends Module> modules) {
        this.injector = Injection.createInjector(this, modules);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.injector.injectMembers(this);
    }

}
