/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Groovy application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.5.1/userguide/building_java_projects.html
 */

plugins {
    // Apply the groovy Plugin to add support for Groovy.
    groovy

    // Apply the application plugin to add support for building a CLI application in Java.
    application
    id("shared-build-conventions")
}

dependencies {
    // Use the latest Groovy version for building this library
    implementation("org.codehaus.groovy:groovy-all:3.0.10")

    // Use the awesome Spock testing and specification framework even with Java
    testImplementation("org.spockframework:spock-core:2.1-groovy-3.0")
    testImplementation("junit:junit:4.13.2")
}

application {
    // Define the main class for the application.
    mainClass.set("com.gradle.lab.App")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
