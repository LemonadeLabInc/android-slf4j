package de.lemona.android.guice.system;

import android.content.Context;
import android.net.wifi.WifiManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class WifiManagerProvider extends AbstractServiceProvider<WifiManager> {

    @Inject
    public WifiManagerProvider(Context context) {
        super(Context.WIFI_SERVICE, WifiManager.class, context);
    }

}
