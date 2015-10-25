package de.lemona.android.guice.system;

import android.app.DownloadManager;
import android.content.Context;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DownloadManagerProvider extends AbstractServiceProvider<DownloadManager> {

    @Inject
    public DownloadManagerProvider(Context context) {
        super(Context.DOWNLOAD_SERVICE, DownloadManager.class, context);
    }

}
