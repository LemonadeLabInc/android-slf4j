package de.lemona.android.guice.activity;

import android.app.Activity;
import android.app.Application;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class ActivityApplicationProvider
implements Provider<Application> {

    private final Activity activity;

    @Inject
    private ActivityApplicationProvider(Activity activity) {
        this.activity = activity;
    }

    @Override @Singleton
    public Application get() {
        return activity.getApplication();
    }
}
