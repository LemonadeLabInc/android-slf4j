package de.lemona.android.guice.system;

import android.content.Context;
import android.media.AudioManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class AudioManagerProvider extends AbstractServiceProvider<AudioManager> {

    @Inject
    public AudioManagerProvider(Context context) {
        super(Context.AUDIO_SERVICE, AudioManager.class, context);
    }

}
