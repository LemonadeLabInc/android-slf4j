Google Guice wrapper for Android
================================

This is a minimal wrapper for [Google Guice](https://github.com/google/guice)
making it somehow more friendly in Android environments.

[![Download](https://api.bintray.com/packages/lemonade/maven/android-guice/images/download.svg) ](https://bintray.com/lemonade/maven/android-guice/_latestVersion)

Usage
-----

Depending on your build system, your mileage might vary, but with
[Gradle](https://gradle.org/) the only required changes to your build files
should be limited to adding our [repository](https://bintray.com/lemonade/maven),
then declaring the dependency:

```groovy
// Our Bintray repository
repositories {
  maven {
    url 'http://dl.bintray.com/lemonade/maven'
  }
}

// Easy dependency!
dependencies {
  compile 'de.lemona.android:android-guice:X.Y.Z'
}
```


License
-------

Licensed under the [Apache License version 2](LICENSE.md)
