package de.lemona.android.guice.system;

import android.content.Context;
import android.os.PowerManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class PowerManagerProvider extends AbstractServiceProvider<PowerManager> {

    @Inject
    public PowerManagerProvider(Context context) {
        super(Context.POWER_SERVICE, PowerManager.class, context);
    }

}
