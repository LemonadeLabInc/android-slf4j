package de.lemona.android.guice.system;

import android.content.Context;
import android.os.storage.StorageManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class StorageManagerProvider extends AbstractServiceProvider<StorageManager> {

    @Inject
    public StorageManagerProvider(Context context) {
        super(Context.STORAGE_SERVICE, StorageManager.class, context);
    }

}
