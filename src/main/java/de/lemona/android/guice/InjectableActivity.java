package de.lemona.android.guice;

import java.util.Arrays;

import com.google.inject.Module;

import android.app.Activity;
import android.os.Bundle;

public abstract class InjectableActivity extends Activity {

    static { Injection.init(); }

    private volatile Injector injector = null;
    private final Iterable<? extends Module> modules;

    protected InjectableActivity(Module... modules) {
        this.modules = modules == null ? null : Arrays.asList(modules);
    }

    protected InjectableActivity(Iterable<? extends Module> modules) {
        this.modules = modules;
    }

    protected Injector getInjector() {
        if (injector == null) throw new IllegalStateException("Injector unavailable");
        return injector;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (this.injector == null) {
            this.injector = Injection.createInjector(this, modules);
            this.injector.injectMembers(this);
        }
    }
}
