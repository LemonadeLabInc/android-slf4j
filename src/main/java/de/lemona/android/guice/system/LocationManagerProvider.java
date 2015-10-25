package de.lemona.android.guice.system;

import android.content.Context;
import android.location.LocationManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class LocationManagerProvider extends AbstractServiceProvider<LocationManager> {

    @Inject
    public LocationManagerProvider(Context context) {
        super(Context.LOCATION_SERVICE, LocationManager.class, context);
    }

}
