package de.lemona.android.guice.system;

import android.content.Context;
import android.os.Vibrator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class VibratorProvider extends AbstractServiceProvider<Vibrator> {

    @Inject
    public VibratorProvider(Context context) {
        super(Context.VIBRATOR_SERVICE, Vibrator.class, context);
    }

}
