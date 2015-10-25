package de.lemona.android.guice.activity;

import android.app.ActionBar;
import android.app.Activity;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class ActionBarProvider
implements Provider<ActionBar> {

    private final Activity activity;

    @Inject
    private ActionBarProvider(Activity activity) {
        this.activity = activity;
    }

    @Override @Singleton
    public ActionBar get() {
        return activity.getActionBar();
    }
}
