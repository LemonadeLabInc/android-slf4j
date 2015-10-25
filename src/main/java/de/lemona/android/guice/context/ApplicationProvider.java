package de.lemona.android.guice.context;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.ProvisionException;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;

public class ApplicationProvider implements Provider<Application> {

    //@Inject(optional=true) Activity activity;
    //@Inject(optional=true) Service service;

    private final Context context;

    @Inject
    private ApplicationProvider(Context context) {
        this.context = context;
        // Nothing to do...
    }

    @Override
    public Application get() {
        if (context instanceof Activity) return ((Activity) context).getApplication();
        if (context instanceof Service) return ((Service) context).getApplication();
//        if (activity != null) return activity.getApplication();
//        if (service != null) return service.getApplication();
        throw new ProvisionException("Activity and/or Service not available");
    }
}
