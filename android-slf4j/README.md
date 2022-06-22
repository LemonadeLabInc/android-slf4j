Slf4J wrapper for Android
=========================

This is a minimal wrapper for [Slf4J](http://www.slf4j.org/) using the Android
[LogCat](http://developer.android.com/reference/android/util/Log.html) facility.

Usage
-----

Depending on your build system, your mileage might vary, but with
[Gradle](https://gradle.org/) the only required changes to your build files
should be limited to adding our [repository](https://bintray.com/lemonade/maven),
then declaring the dependency:

```groovy
// Depend on the SLF4J API for compilation targets and on the wrapper
// for runtime targets... remember to update to the latest versions!
dependencies {
  implementation 'org.slf4j:slf4j-api:1.7.12' // latest at time of writing
  implementation 'de.lemona.android:android-slf4j:X.Y.Z'
}
```

Log Level Change
----------------
In Android, default log level is `INFO`. To switch `DEBUG` use adb command like below.
```
adb shell setprop log.tag.Slf4J DEBUG
```


Notes
-----

Please note that this wrapper is not intended in any way to be particularly
performant or fast, as it is mainly intended for testing environment. Usage on
released apps should be considered with caution.

Everything is logged with the `Slf4J` tag in order to facilitate `logcat` usage:

```console
$ adb logcat -s 'Slf4J:d'
I/Slf4J   ( 8589): org.example.test.MyClass: Hello, world
I/Slf4J   ( 8589): org.example.test.MyClass: Somehow we got an exception
I/Slf4J   ( 8589): java.lang.Exception: Test exception
I/Slf4J   ( 8589):  at org.example.test.MyClass.testMethod(MyClass.java:36)
I/Slf4J   ( 8589):  at ...
^C
$
```

License
-------

Licensed under the [Apache License version 2](../LICENSE.md)
