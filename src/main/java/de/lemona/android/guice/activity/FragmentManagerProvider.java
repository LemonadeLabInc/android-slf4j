package de.lemona.android.guice.activity;

import android.app.Activity;
import android.app.FragmentManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class FragmentManagerProvider
implements Provider<FragmentManager> {

    private final Activity activity;

    @Inject
    private FragmentManagerProvider(Activity activity) {
        this.activity = activity;
    }

    @Override @Singleton
    public FragmentManager get() {
        return activity.getFragmentManager();
    }
}
