package de.lemona.android.guice.system;

import android.app.AlarmManager;
import android.content.Context;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class AlarmManagerProvider extends AbstractServiceProvider<AlarmManager> {

    @Inject
    public AlarmManagerProvider(Context context) {
        super(Context.ALARM_SERVICE, AlarmManager.class, context);
    }

}
