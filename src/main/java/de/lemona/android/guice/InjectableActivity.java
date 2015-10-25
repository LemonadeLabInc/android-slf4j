package de.lemona.android.guice;

import com.google.inject.Module;

import android.app.Activity;
import android.os.Bundle;

public abstract class InjectableActivity extends Activity {

    protected final Injector injector;// = new InjectorWrapper();

    protected InjectableActivity(Module... modules) {
        this.injector = Injection.createInjector(this, modules);
    }

    protected InjectableActivity(Iterable<? extends Module> modules) {
        this.injector = Injection.createInjector(this, modules);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.injector.injectMembers(this);
    }
}
