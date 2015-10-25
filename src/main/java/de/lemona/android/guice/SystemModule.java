package de.lemona.android.guice;

import com.google.inject.Binder;
import com.google.inject.Module;

import de.lemona.android.guice.system.ActivityManagerProvider;
import de.lemona.android.guice.system.AlarmManagerProvider;
import de.lemona.android.guice.system.AudioManagerProvider;
import de.lemona.android.guice.system.BatteryManagerProvider;
import de.lemona.android.guice.system.ConnectivityManagerProvider;
import de.lemona.android.guice.system.DownloadManagerProvider;
import de.lemona.android.guice.system.InputMethodManagerProvider;
import de.lemona.android.guice.system.JobSchedulerProvider;
import de.lemona.android.guice.system.KeyguardManagerProvider;
import de.lemona.android.guice.system.LayoutInflaterProvider;
import de.lemona.android.guice.system.LocationManagerProvider;
import de.lemona.android.guice.system.MediaRouterProvider;
import de.lemona.android.guice.system.NotificationManagerProvider;
import de.lemona.android.guice.system.PowerManagerProvider;
import de.lemona.android.guice.system.SearchManagerProvider;
import de.lemona.android.guice.system.SensorManagerProvider;
import de.lemona.android.guice.system.StorageManagerProvider;
import de.lemona.android.guice.system.SubscriptionManagerProvider;
import de.lemona.android.guice.system.TelephonyManagerProvider;
import de.lemona.android.guice.system.UiModeManagerProvider;
import de.lemona.android.guice.system.VibratorProvider;
import de.lemona.android.guice.system.WifiManagerProvider;
import de.lemona.android.guice.system.WindowManagerProvider;

public class SystemModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(android.app.ActivityManager.class).toProvider(ActivityManagerProvider.class);
        binder.bind(android.app.AlarmManager.class).toProvider(AlarmManagerProvider.class);
        binder.bind(android.app.DownloadManager.class).toProvider(DownloadManagerProvider.class);
        binder.bind(android.app.job.JobScheduler.class).toProvider(JobSchedulerProvider.class);
        binder.bind(android.app.KeyguardManager.class).toProvider(KeyguardManagerProvider.class);
        binder.bind(android.app.NotificationManager.class).toProvider(NotificationManagerProvider.class);
        binder.bind(android.app.SearchManager.class).toProvider(SearchManagerProvider.class);
        binder.bind(android.app.UiModeManager.class).toProvider(UiModeManagerProvider.class);
        binder.bind(android.hardware.SensorManager.class).toProvider(SensorManagerProvider.class);
        binder.bind(android.location.LocationManager.class).toProvider(LocationManagerProvider.class);
        binder.bind(android.media.AudioManager.class).toProvider(AudioManagerProvider.class);
        binder.bind(android.media.MediaRouter.class).toProvider(MediaRouterProvider.class);
        binder.bind(android.net.ConnectivityManager.class).toProvider(ConnectivityManagerProvider.class);
        binder.bind(android.net.wifi.WifiManager.class).toProvider(WifiManagerProvider.class);
        binder.bind(android.os.BatteryManager.class).toProvider(BatteryManagerProvider.class);
        binder.bind(android.os.PowerManager.class).toProvider(PowerManagerProvider.class);
        binder.bind(android.os.storage.StorageManager.class).toProvider(StorageManagerProvider.class);
        binder.bind(android.os.Vibrator.class).toProvider(VibratorProvider.class);
        binder.bind(android.telephony.SubscriptionManager.class).toProvider(SubscriptionManagerProvider.class);
        binder.bind(android.telephony.TelephonyManager.class).toProvider(TelephonyManagerProvider.class);
        binder.bind(android.view.inputmethod.InputMethodManager.class).toProvider(InputMethodManagerProvider.class);
        binder.bind(android.view.LayoutInflater.class).toProvider(LayoutInflaterProvider.class);
        binder.bind(android.view.WindowManager.class).toProvider(WindowManagerProvider.class);
    }
}
