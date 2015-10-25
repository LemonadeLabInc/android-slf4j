package de.lemona.android.guice;

import java.util.Arrays;

import com.google.inject.Module;

import android.app.Service;

public abstract class InjectableService extends Service {

    protected final Injector injector = new InjectorWrapper();

    private final Iterable<? extends Module> modules;

    protected InjectableService(Module... modules) {
        this.modules = modules == null ? null : modules.length == 0 ? null : Arrays.asList(modules);
    }

    protected InjectableService(Iterable<? extends Module> modules) {
        this.modules = modules;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        final InjectorWrapper wrapper = (InjectorWrapper) injector;
        if (wrapper.injector != null) throw new IllegalStateException("Already injected");
        wrapper.injector = Injection.createInjector(this, modules).getInjector();
        wrapper.injectMembers(this);
    }

    @Override
    public void onDestroy() {
        ((InjectorWrapper) injector).injector = null;
        super.onDestroy();
    }
}
