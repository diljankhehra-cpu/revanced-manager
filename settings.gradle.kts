pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven("https://jitpack.io")
        maven {
            name = "githubPackages"
            url = uri("https://maven.pkg.github.com/revanced/registry")
            credentials {
                username = System.getenv("GITHUB_PACKAGES_USERNAME") ?: project.findProperty("githubPackagesUsername")?.toString() ?: ""
                password = System.getenv("GITHUB_PACKAGES_PASSWORD") ?: project.findProperty("githubPackagesPassword")?.toString() ?: ""
            }
        }
    }
}

rootProject.name = "revanced-manager"
include(":app", ":api")
