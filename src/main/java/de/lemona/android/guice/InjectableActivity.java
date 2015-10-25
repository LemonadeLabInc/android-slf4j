package de.lemona.android.guice;

import java.util.Arrays;

import com.google.inject.Module;

import android.app.Activity;
import android.os.Bundle;

public abstract class InjectableActivity extends Activity {

    protected final Injector injector = new InjectorWrapper();

    private final Iterable<? extends Module> modules;

    protected InjectableActivity(Module... modules) {
        this.modules = modules == null ? null : modules.length == 0 ? null : Arrays.asList(modules);
    }

    protected InjectableActivity(Iterable<? extends Module> modules) {
        this.modules = modules;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final InjectorWrapper wrapper = (InjectorWrapper) injector;
        if (wrapper.injector != null) throw new IllegalStateException("Already injected");
        wrapper.injector = Injection.createInjector(this, modules).getInjector();
        wrapper.injectMembers(this);
    }

    @Override
    protected void onDestroy() {
        ((InjectorWrapper) injector).injector = null;
        super.onDestroy();
    }
}
