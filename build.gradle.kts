plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version ("8.1.1")
}

subprojects {
    if(name == "java-test") {
        return@subprojects
    }

    apply(plugin = "java")
    apply(plugin = "com.github.johnrengelman.shadow")
    apply(plugin = "maven-publish")

    repositories {
        mavenCentral()
    }

    tasks {
        shadowJar {
            archiveBaseName.set("GelattoLabs-${project.name.uppercase()}")
            archiveVersion.set("${project.properties.getValue("version")}")
            archiveClassifier.set("")
        }

        // All dependsOn()
        build {
            dependsOn("shadowJar")
        }
    }
}