pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DailyQuiz"
include(":app", ":core:ui")
include(":core:database")
include(":core:network")
include(":core:model")
include(":feature:quiz")
include(":feature:history")
include(":navigation")
include(":feature:review")
include(":core:di")
