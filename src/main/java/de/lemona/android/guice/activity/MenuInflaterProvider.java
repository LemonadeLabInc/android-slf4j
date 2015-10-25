package de.lemona.android.guice.activity;

import android.app.Activity;
import android.view.MenuInflater;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class MenuInflaterProvider
implements Provider<MenuInflater> {

    private final Activity activity;

    @Inject
    private MenuInflaterProvider(Activity activity) {
        this.activity = activity;
    }

    @Override @Singleton
    public MenuInflater get() {
        return activity.getMenuInflater();
    }
}
