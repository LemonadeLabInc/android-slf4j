package de.lemona.android.guice.system;

import android.app.NotificationManager;
import android.content.Context;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class NotificationManagerProvider extends AbstractServiceProvider<NotificationManager> {

    @Inject
    public NotificationManagerProvider(Context context) {
        super(Context.NOTIFICATION_SERVICE, NotificationManager.class, context);
    }

}
