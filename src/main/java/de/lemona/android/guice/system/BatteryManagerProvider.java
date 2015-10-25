package de.lemona.android.guice.system;

import android.content.Context;
import android.os.BatteryManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class BatteryManagerProvider extends AbstractServiceProvider<BatteryManager> {

    @Inject
    public BatteryManagerProvider(Context context) {
        super(Context.BATTERY_SERVICE, BatteryManager.class, context);
    }

}
