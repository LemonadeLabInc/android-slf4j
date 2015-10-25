package de.lemona.android.guice;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;

import com.google.inject.Binder;
import com.google.inject.Module;

import de.lemona.android.guice.context.ApplicationContextProvider;
import de.lemona.android.guice.context.ApplicationInfoProvider;
import de.lemona.android.guice.context.AssetManagerProvider;
import de.lemona.android.guice.context.ContentResolverProvider;
import de.lemona.android.guice.context.PackageManagerProvider;

public class ContextModule implements Module {

    private final Context context;

    public ContextModule(Context context) {
        if (context == null) throw new NullPointerException("Null context");
        this.context = context;
    }

    @Override
    public void configure(Binder binder) {
        // Basic context and application context
        binder.bind(Context.class).annotatedWith(AppContext.class).toProvider(ApplicationContextProvider.class);
        binder.bind(Context.class).toInstance(context);

        // Context-derived instances
        binder.bind(ApplicationInfo.class).toProvider(ApplicationInfoProvider.class);
        binder.bind(AssetManager.class).toProvider(AssetManagerProvider.class);
        binder.bind(ContentResolver.class).toProvider(ContentResolverProvider.class);
        binder.bind(PackageManager.class).toProvider(PackageManagerProvider.class);
    }
}
