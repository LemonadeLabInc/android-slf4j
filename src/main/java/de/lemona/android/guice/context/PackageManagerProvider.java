package de.lemona.android.guice.context;

import android.content.Context;
import android.content.pm.PackageManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class PackageManagerProvider
implements Provider<PackageManager> {

    private final Context context;

    @Inject
    private PackageManagerProvider(Context context) {
        this.context = context;
    }

    @Override @Singleton
    public PackageManager get() {
        return context.getPackageManager();
    }
}
