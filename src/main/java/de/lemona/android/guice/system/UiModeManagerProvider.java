package de.lemona.android.guice.system;

import android.app.UiModeManager;
import android.content.Context;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class UiModeManagerProvider extends AbstractServiceProvider<UiModeManager> {

    @Inject
    public UiModeManagerProvider(Context context) {
        super(Context.UI_MODE_SERVICE, UiModeManager.class, context);
    }

}
