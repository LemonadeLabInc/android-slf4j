package de.lemona.android.guice.context;

import android.app.Application;
import android.app.Service;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class ServiceApplicationProvider
implements Provider<Application> {

    private final Service service;

    @Inject
    private ServiceApplicationProvider(Service service) {
        this.service = service;
    }

    @Override @Singleton
    public Application get() {
        return service.getApplication();
    }
}
