# Hello Android Studio &nbsp;&nbsp; [![Build Status](https://travis-ci.org/twotoasters/HelloAndroidStudio.png?branch=master)](https://travis-ci.org/twotoasters/HelloAndroidStudio)

A Gradle sample project that demonstrates usage of many common tasks.

## Sample Tasks

- adding project dependency (.JAR) from maven central
- adding a library project dependency (.AAR) from maven central
- including the Android support library
- adding testing-only project dependencies
- writing instrumentation tests
- writing junit tests with robolectric

## Notes

- Instrumentation tests are currently broken on Gradle 1.7
- Instrumentation tests can be run with "gradle connectedInstrumentTest"
- Robolectric junit tests can be run with "gradle clean test"