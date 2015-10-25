package de.lemona.android.guice;

import com.google.inject.Binder;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.ComponentName;
import android.media.session.MediaController;
import android.transition.TransitionManager;
import android.view.MenuInflater;
import android.view.Window;
import de.lemona.android.guice.activity.ActionBarProvider;
import de.lemona.android.guice.activity.ComponentNameProvider;
import de.lemona.android.guice.activity.FragmentManagerProvider;
import de.lemona.android.guice.activity.LoaderManagerProvider;
import de.lemona.android.guice.activity.MediaControllerProvider;
import de.lemona.android.guice.activity.MenuInflaterProvider;
import de.lemona.android.guice.activity.TransitionManagerProvider;
import de.lemona.android.guice.activity.WindowProvider;

public class ActivityModule extends ContextModule {

    static { Injection.init(); }

    private final Activity activity;

    public ActivityModule(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    public void configure(Binder binder) {
        super.configure(binder);

        // Activity, decoupled from the "toInstance(...)" automatic injection
        binder.bind(Activity.class).toProvider(new InstanceProvider<>(activity));

        // Providers for activity-related components
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
