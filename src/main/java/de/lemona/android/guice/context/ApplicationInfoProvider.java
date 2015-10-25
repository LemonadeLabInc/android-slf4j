package de.lemona.android.guice.context;

import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class ApplicationInfoProvider
implements Provider<ApplicationInfo> {

    private final Context context;

    @Inject
    private ApplicationInfoProvider(Context context) {
        this.context = context;
    }

    @Override @Singleton
    public ApplicationInfo get() {
        return context.getApplicationInfo();
    }
}
