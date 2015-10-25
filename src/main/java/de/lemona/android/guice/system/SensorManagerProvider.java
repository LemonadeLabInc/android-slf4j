package de.lemona.android.guice.system;

import android.content.Context;
import android.hardware.SensorManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class SensorManagerProvider extends AbstractServiceProvider<SensorManager> {

    @Inject
    public SensorManagerProvider(Context context) {
        super(Context.SENSOR_SERVICE, SensorManager.class, context);
    }

}
