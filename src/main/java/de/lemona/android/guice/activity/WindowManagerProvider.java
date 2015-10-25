package de.lemona.android.guice.activity;

import android.app.Activity;
import android.view.WindowManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class WindowManagerProvider
implements Provider<WindowManager> {

    private final Activity activity;

    @Inject
    private WindowManagerProvider(Activity activity) {
        this.activity = activity;
    }

    @Override @Singleton
    public WindowManager get() {
        return activity.getWindowManager();
    }
}
