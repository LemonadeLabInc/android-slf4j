# Slf4J with Firebase Crashlytics 

A simple implementation of [Slf4J API](http://www.slf4j.org/) 
using the Android [LogCat](http://developer.android.com/reference/android/util/Log.html)
and [Firebase Crashlytics](https://firebase.google.com/docs/crashlytics).

Sending log events to Crashlytics when calling `Logger#warn()` or `Logger#error()`

## Usage

### Gradle
```groovy
dependencies {
    implementation 'de.lemona.android:crashlytics-slf4j:X.Y.Z'
}
```

And [set up Firebase Crashlytics](https://firebase.google.com/docs/crashlytics/get-started?platform=android) on your app

## Log Level Change

In Android, default log level is `INFO`. To switch `DEBUG` use adb command like below.
```
adb shell setprop log.tag.Slf4J DEBUG
```
