## JVM Builds with Gradle Build Tool - Exercise 2

<p align="left">
<img width="10%" height="10%" src="https://user-images.githubusercontent.com/120980/174325546-8558160b-7f16-42cb-af0f-511849f22ebc.png">
</p>

This is a hands-on exercise to go along with the
**JVM Builds with Gradle Build Tool** training module. In this exercise
you will get familiar with the following topics:

* Get familiar with Toolchains

---
### Prerequisites

* Completed exercise 1

---
### Configure Java Version for Whole Project

Add a toolchain that specifies to use `Java 11` for the project,
do this in the buildSrc shared configuration.

```kotlin
java {
    toolchain {
        // Your configuration goes here.
    }
}
```

*Hint:* If you get stuck refer to this
[documentation](https://docs.gradle.org/current/userguide/toolchains.html).

### Configure Java Version for Specific Task

How let's update the `extraSrc` sources to use some new functionality that
was added after Java 11. Modify the `extraSrc` source file to include the
following code in the `main` method:

```java
String msg = "Hello Extra! Time is " + LocalTime.now().toString();
System.out.println(msg.indent(4));
```

Now if you try running the code it will fail:

```bash
./gradlew :<subproject>:runExtra
```

Now modify the configuration for the `compileExtraJava` and `runExtra`
tasks to use `Java 17` using the toolchain configuration.

```kotlin
tasks.named<JavaCompile>("compileExtraJava") {
    // Your configuration here.
}
tasks.register<JavaExec>("runExtra") {
    // Your configuration here.
}
```

*Hint:* You can refer to
[this documentation](https://docs.gradle.org/current/userguide/toolchains.html#specify_custom_toolchains_for_individual_tasks).

Now when you execute the `runExtra` task it will succeed:

```bash
./gradlew :<subproject>:runExtra
```