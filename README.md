junsigned
===

[![Maven Central](https://img.shields.io/maven-central/v/com.io7m.junsigned/com.io7m.junsigned.svg?style=flat-square)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.io7m.junsigned%22)
[![Maven Central (snapshot)](https://img.shields.io/nexus/s/com.io7m.junsigned/com.io7m.junsigned?server=https%3A%2F%2Fs01.oss.sonatype.org&style=flat-square)](https://s01.oss.sonatype.org/content/repositories/snapshots/com/io7m/junsigned/)
[![Codecov](https://img.shields.io/codecov/c/github/io7m-com/junsigned.svg?style=flat-square)](https://codecov.io/gh/io7m-com/junsigned)
![Java Version](https://img.shields.io/badge/21-java?label=java&color=e6c35c)

![com.io7m.junsigned](./src/site/resources/junsigned.jpg?raw=true)

| JVM | Platform | Status |
|-----|----------|--------|
| OpenJDK (Temurin) Current | Linux | [![Build (OpenJDK (Temurin) Current, Linux)](https://img.shields.io/github/actions/workflow/status/io7m-com/junsigned/main.linux.temurin.current.yml)](https://www.github.com/io7m-com/junsigned/actions?query=workflow%3Amain.linux.temurin.current)|
| OpenJDK (Temurin) LTS | Linux | [![Build (OpenJDK (Temurin) LTS, Linux)](https://img.shields.io/github/actions/workflow/status/io7m-com/junsigned/main.linux.temurin.lts.yml)](https://www.github.com/io7m-com/junsigned/actions?query=workflow%3Amain.linux.temurin.lts)|
| OpenJDK (Temurin) Current | Windows | [![Build (OpenJDK (Temurin) Current, Windows)](https://img.shields.io/github/actions/workflow/status/io7m-com/junsigned/main.windows.temurin.current.yml)](https://www.github.com/io7m-com/junsigned/actions?query=workflow%3Amain.windows.temurin.current)|
| OpenJDK (Temurin) LTS | Windows | [![Build (OpenJDK (Temurin) LTS, Windows)](https://img.shields.io/github/actions/workflow/status/io7m-com/junsigned/main.windows.temurin.lts.yml)](https://www.github.com/io7m-com/junsigned/actions?query=workflow%3Amain.windows.temurin.lts)|

## junsigned

Functions to convert unsigned int/long values to/from float/double values.

## Features

* Functions to convert unsigned int/long values to/from float/double values.
* Unsigned modulus implementations.
* Unsigned variants of [jranges](https://www.github.com/io7m-com/jranges) functions and types.
* High coverage test suite.
* [OSGi-ready](https://www.osgi.org/)
* [JPMS-ready](https://en.wikipedia.org/wiki/Java_Platform_Module_System)
* ISC license.

## Usage

Use the `UnsignedDouble` class to convert from various integer types to
`double` values.

Use the `UnsignedFloat` class to convert from various integer types to
`float` values.

Use the `UnsignedLong` class to perform unsigned modulus operations on `long`
values.

Use the `UnsignedInt` class to perform unsigned modulus operations on `int`
values.

