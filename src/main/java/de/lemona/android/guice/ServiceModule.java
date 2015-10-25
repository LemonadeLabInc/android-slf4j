package de.lemona.android.guice;

import android.app.Activity;
import android.app.Application;
import android.app.Service;

import com.google.inject.Binder;
import com.google.inject.Module;

public class ServiceModule implements Module {

    private final Service service;

    public ServiceModule(Service service) {
        this.service = service;
    }

    @Override
    public void configure(Binder binder) {
        binder.bind(Service.class).toInstance(service);
        binder.bind(Application.class).toInstance(service.getApplication());
    }
}
