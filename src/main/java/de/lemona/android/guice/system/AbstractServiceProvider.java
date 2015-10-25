package de.lemona.android.guice.system;

import android.content.Context;

import com.google.inject.Provider;
import com.google.inject.Singleton;

public abstract class AbstractServiceProvider<T>
implements Provider<T> {

    private final String key;
    private final Class<T> type;
    private final Context context;

    protected AbstractServiceProvider(String key, Class<T> type, Context context) {
        this.key = key;
        this.type = type;
        this.context = context;
    }

    @Override @Singleton
    public T get() {
        return type.cast(context.getSystemService(key));
    }
}
