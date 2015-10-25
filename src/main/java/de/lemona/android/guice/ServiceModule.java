package de.lemona.android.guice;

import com.google.inject.Binder;

import android.app.Application;
import android.app.Service;
import de.lemona.android.guice.context.ApplicationProvider;

public class ServiceModule extends ContextModule {

    static { Injection.init(); }

    private final Service service;

    public ServiceModule(Service service) {
        super(service);
        this.service = service;
    }

    @Override
    public void configure(Binder binder) {
        super.configure(binder);

        binder.bind(Service.class).toProvider(new InstanceProvider<>(service));
        binder.bind(Application.class).toProvider(ApplicationProvider.class);
    }
}
