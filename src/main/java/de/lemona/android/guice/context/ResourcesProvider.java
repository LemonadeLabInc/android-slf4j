package de.lemona.android.guice.context;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import android.content.Context;
import android.content.res.Resources;

@Singleton
public class ResourcesProvider
implements Provider<Resources> {

    private final Context context;

    @Inject
    private ResourcesProvider(Context context) {
        this.context = context;
    }

    @Override @Singleton
    public Resources get() {
        return context.getResources();
    }
}
