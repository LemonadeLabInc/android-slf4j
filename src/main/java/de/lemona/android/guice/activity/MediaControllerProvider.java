package de.lemona.android.guice.activity;

import android.app.Activity;
import android.media.session.MediaController;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class MediaControllerProvider
implements Provider<MediaController> {

    private final Activity activity;

    @Inject
    private MediaControllerProvider(Activity activity) {
        this.activity = activity;
    }

    @Override @Singleton
    public MediaController get() {
        return activity.getMediaController();
    }
}
