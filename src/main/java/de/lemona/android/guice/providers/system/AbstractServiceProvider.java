package de.lemona.android.guice.providers.system;

import com.google.inject.Provider;

import android.content.Context;

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

    @Override
    public T get() {
        return type.cast(context.getSystemService(key));
    }
}
