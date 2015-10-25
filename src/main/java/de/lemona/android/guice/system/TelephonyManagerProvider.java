package de.lemona.android.guice.system;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class TelephonyManagerProvider extends AbstractServiceProvider<TelephonyManager> {

    @Inject
    public TelephonyManagerProvider(Context context) {
        super(Context.TELEPHONY_SERVICE, TelephonyManager.class, context);
    }

}
