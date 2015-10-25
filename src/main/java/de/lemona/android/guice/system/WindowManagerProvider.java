package de.lemona.android.guice.system;

import android.content.Context;
import android.view.WindowManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class WindowManagerProvider extends AbstractServiceProvider<WindowManager> {

    @Inject
    public WindowManagerProvider(Context context) {
        super(Context.WINDOW_SERVICE, WindowManager.class, context);
    }

}
