package de.lemona.android.guice.system;

import android.app.ActivityManager;
import android.content.Context;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ActivityManagerProvider extends AbstractServiceProvider<ActivityManager> {

    @Inject
    public ActivityManagerProvider(Context context) {
        super(Context.ACTIVITY_SERVICE, ActivityManager.class, context);
    }

}
