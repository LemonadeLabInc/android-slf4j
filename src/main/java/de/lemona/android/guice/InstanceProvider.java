package de.lemona.android.guice;

import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class InstanceProvider<T> implements Provider<T> {

    private final T instance;

    public InstanceProvider(T instance) {
        this.instance = instance;
    }

    @Singleton
    @Override
    public T get() {
        return instance;
    }

}
