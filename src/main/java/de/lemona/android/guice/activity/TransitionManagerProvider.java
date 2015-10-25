package de.lemona.android.guice.activity;

import android.app.Activity;
import android.transition.TransitionManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class TransitionManagerProvider
implements Provider<TransitionManager> {

    private final Activity activity;

    @Inject
    private TransitionManagerProvider(Activity activity) {
        this.activity = activity;
    }

    @Override @Singleton
    public TransitionManager get() {
        return activity.getContentTransitionManager();
    }
}
