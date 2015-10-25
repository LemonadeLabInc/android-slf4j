package de.lemona.android.guice.activity;

import android.app.Activity;
import android.app.LoaderManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class LoaderManagerProvider
implements Provider<LoaderManager> {

    private final Activity activity;

    @Inject
    private LoaderManagerProvider(Activity activity) {
        this.activity = activity;
    }

    @Override @Singleton
    public LoaderManager get() {
        return activity.getLoaderManager();
    }
}
