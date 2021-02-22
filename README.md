libyuv-anrdroid
=================

[![Android CI](https://github.com/crow-misia/libyuv-android/actions/workflows/android.yml/badge.svg?branch=main)](https://github.com/crow-misia/libyuv-android/actions/workflows/android.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.crow-misia.libyuv/libyuv-android.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.crow-misia.libyuv%22%20AND%20a:%22libyuv-android%22)
[![License](https://img.shields.io/github/license/crow-misia/libyuv-android)](LICENSE)

## Get Started

### Gradle

Add dependencies (you can also add other modules that you need):

`${latest.version}` is [![Maven Central](https://img.shields.io/maven-central/v/io.github.crow-misia.libyuv/libyuv-android.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.crow-misia.libyuv%22%20AND%20a:%22libyuv-android%22)

```groovy
dependencies {
    implementation "io.github.crow-misia.libyuv:libyuv-android:${latest.version}"
}
```

Make sure that you have either `mavenCentral()` in the list of repositories:

```
repository {
    mavenCentral()
}
```

## License

The code in libyuv (https://chromium.googlesource.com/libyuv/libyuv/) follows the license and patent descriptions of libyuv.
See LICENSE_LIBYUV and PATENTS_LIBYUV under the root of this repository. The originals can be found at the following URL.

https://chromium.googlesource.com/libyuv/libyuv/+/master/LICENSE
https://chromium.googlesource.com/libyuv/libyuv/+/master/PATENTS

```
Copyright 2020, Zenichi Amano.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
