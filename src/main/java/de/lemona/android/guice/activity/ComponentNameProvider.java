package de.lemona.android.guice.activity;

import android.app.Activity;
import android.content.ComponentName;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class ComponentNameProvider
implements Provider<ComponentName> {

    private final Activity activity;

    @Inject
    private ComponentNameProvider(Activity activity) {
        this.activity = activity;
    }

    @Override @Singleton
    public ComponentName get() {
        return activity.getComponentName();
    }
}
