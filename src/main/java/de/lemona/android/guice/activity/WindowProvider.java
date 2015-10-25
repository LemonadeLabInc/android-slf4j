package de.lemona.android.guice.activity;

import android.app.Activity;
import android.view.Window;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class WindowProvider
implements Provider<Window> {

    private final Activity activity;

    @Inject
    private WindowProvider(Activity activity) {
        this.activity = activity;
    }

    @Override @Singleton
    public Window get() {
        return activity.getWindow();
    }
}
