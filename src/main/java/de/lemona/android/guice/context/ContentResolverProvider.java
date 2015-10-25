package de.lemona.android.guice.context;

import android.content.ContentResolver;
import android.content.Context;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class ContentResolverProvider
implements Provider<ContentResolver> {

    private final Context context;

    @Inject
    private ContentResolverProvider(Context context) {
        this.context = context;
    }

    @Override @Singleton
    public ContentResolver get() {
        return context.getContentResolver();
    }
}
