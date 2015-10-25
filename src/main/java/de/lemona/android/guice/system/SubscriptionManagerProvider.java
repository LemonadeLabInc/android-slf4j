package de.lemona.android.guice.system;

import android.content.Context;
import android.telephony.SubscriptionManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class SubscriptionManagerProvider extends AbstractServiceProvider<SubscriptionManager> {

    @Inject
    public SubscriptionManagerProvider(Context context) {
        super(Context.TELEPHONY_SUBSCRIPTION_SERVICE, SubscriptionManager.class, context);
    }

}
