package de.lemona.android.guice;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.ComponentName;
import android.media.session.MediaController;
import android.transition.TransitionManager;
import android.view.MenuInflater;
import android.view.Window;

import com.google.inject.Binder;
import com.google.inject.Module;

import de.lemona.android.guice.activity.ActionBarProvider;
import de.lemona.android.guice.activity.ActivityApplicationProvider;
import de.lemona.android.guice.activity.ComponentNameProvider;
import de.lemona.android.guice.activity.FragmentManagerProvider;
import de.lemona.android.guice.activity.LoaderManagerProvider;
import de.lemona.android.guice.activity.MediaControllerProvider;
import de.lemona.android.guice.activity.MenuInflaterProvider;
import de.lemona.android.guice.activity.TransitionManagerProvider;
import de.lemona.android.guice.activity.WindowProvider;

public class ActivityModule implements Module {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        if (activity == null) throw new NullPointerException("Null activity");
        this.activity = activity;
    }

    @Override
    public void configure(Binder binder) {
        // Activity and Application
        binder.bind(Activity.class).toInstance(activity);

        // Providers for activity-related components
        binder.bind(Application.class).toProvider(ActivityApplicationProvider.class);
        binder.bind(ActionBar.class).toProvider(ActionBarProvider.class);
        binder.bind(ComponentName.class).toProvider(ComponentNameProvider.class);
        binder.bind(FragmentManager.class).toProvider(FragmentManagerProvider.class);
        binder.bind(LoaderManager.class).toProvider(LoaderManagerProvider.class);
        binder.bind(MediaController.class).toProvider(MediaControllerProvider.class);
        binder.bind(MenuInflater.class).toProvider(MenuInflaterProvider.class);
        binder.bind(TransitionManager.class).toProvider(TransitionManagerProvider.class);
        binder.bind(Window.class).toProvider(WindowProvider.class);
    }
}
