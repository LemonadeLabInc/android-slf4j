package de.lemona.android.guice.context;

import android.content.Context;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class ApplicationContextProvider
implements Provider<Context> {

    private final Context context;

    @Inject
    private ApplicationContextProvider(Context context) {
        this.context = context;
    }

    @Override @Singleton
    public Context get() {
        return context.getApplicationContext();
    }
}
