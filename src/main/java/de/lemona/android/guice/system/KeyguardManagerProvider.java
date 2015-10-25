package de.lemona.android.guice.system;

import android.app.KeyguardManager;
import android.content.Context;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class KeyguardManagerProvider extends AbstractServiceProvider<KeyguardManager> {

    @Inject
    public KeyguardManagerProvider(Context context) {
        super(Context.KEYGUARD_SERVICE, KeyguardManager.class, context);
    }

}
