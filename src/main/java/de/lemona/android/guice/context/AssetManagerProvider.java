package de.lemona.android.guice.context;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class AssetManagerProvider
implements Provider<AssetManager> {

    private final Context context;

    @Inject
    private AssetManagerProvider(Context context) {
        this.context = context;
    }

    @Override @Singleton
    public AssetManager get() {
        return context.getAssets();
    }
}
