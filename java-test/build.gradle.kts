plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":java-sdk"))
}