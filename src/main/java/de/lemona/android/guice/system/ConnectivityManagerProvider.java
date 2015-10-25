package de.lemona.android.guice.system;

import android.content.Context;
import android.net.ConnectivityManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ConnectivityManagerProvider extends AbstractServiceProvider<ConnectivityManager> {

    @Inject
    public ConnectivityManagerProvider(Context context) {
        super(Context.CONNECTIVITY_SERVICE, ConnectivityManager.class, context);
    }

}
