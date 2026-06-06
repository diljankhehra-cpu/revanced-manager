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
        
        // ReVanced Registry Configuration
        maven {
            name = "githubPackages"
            url = uri("https://maven.pkg.github.com/revanced/registry")
            credentials {
                val username = System.getenv("GITHUB_PACKAGES_USERNAME")
                val password = System.getenv("GITHUB_PACKAGES_PASSWORD")

                if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
                    throw GradleException("❌ ERROR: GITHUB_PACKAGES_USERNAME or GITHUB_PACKAGES_PASSWORD is not set in environment variables! Please check your GitHub Action Secrets.")
                }

                this.username = username
                this.password = password
            }
        }
    }
}

rootProject.name = "revanced-manager"
include(":app", ":api")
