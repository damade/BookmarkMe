import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

private val appVersionName = "1.0.0"
private val appVersionCode = 1

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.androidxRoom)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.koin.compiler)
    // alias(libs.plugins.kmpgen)
}

// Optional configuration
koinCompiler {
    userLogs = true // Log component detection
}

// kmpgen {
//    spec(
//        packageName = "com.bookmark.bookmarkme.api",
//    ) {
//        specFile = file("openapi.yaml")
//    }
// }

ktlint {
    verbose.set(true)
    outputToConsole.set(true)
    coloredOutput.set(true)

    filter {
        exclude("**/build/generated/**")
        exclude("**/jvmMain/**")
        exclude { element -> element.file.path.contains("resourceGenerator") }
    }
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    jvm {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.jetbrains.compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.ktor.client.android)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.koin.compose)
        }
        commonMain.dependencies {
            implementation(libs.jetbrains.compose.runtime)
            implementation(libs.jetbrains.compose.preview)
            implementation(libs.jetbrains.compose.foundation)
            implementation(libs.jetbrains.compose.material3)
            implementation(libs.jetbrains.compose.ui)
            implementation(libs.jetbrains.compose.resources)
            implementation(libs.jetbrains.window.size)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.material.icon.core)
            implementation(libs.bundles.ktor.common)
            implementation(libs.kotlinx.serialization)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.multiplatform.settings.core)
            implementation(libs.multiplatform.settings.coroutines)
            implementation(libs.kermit)
            implementation(libs.androidx.room.runtime)
            implementation(libs.androidx.navigation.compose)
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor)
            implementation(libs.koin.core)
            implementation(libs.koin.annotations)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.koin.test)
        }
        jvmMain.dependencies {
            implementation(libs.ktor.client.java)
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

room {
    schemaDirectory("$projectDir/schemas")
}

android {
    namespace = "com.bookmark.bookmarkme"
    compileSdk =
        libs.versions.android.compileSdk
            .get()
            .toInt()

    defaultConfig {
        applicationId = "com.bookmark.bookmarkme"
        minSdk =
            libs.versions.android.minSdk
                .get()
                .toInt()
        targetSdk =
            libs.versions.android.targetSdk
                .get()
                .toInt()
        versionCode = appVersionCode
        versionName = appVersionName
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(libs.jetbrains.compose.tooling)
    ksp(libs.androidx.room.compiler)
}

compose.desktop {
    application {
        mainClass = "com.bookmark.bookmarkme.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.bookmark.bookmarkme"
            packageVersion = appVersionName
        }
    }
}

// Generate BuildConfig for Desktop
val generateDesktopBuildConfig by tasks.registering {
    val outputDir = layout.buildDirectory.dir("generated/source/buildConfig/jvmMain")
    val versionName = appVersionName
    val versionCode = appVersionCode

    outputs.dir(outputDir)

    doLast {
        val buildConfigDir = outputDir.get().asFile.resolve("com/bookmark/bookmarkme")
        buildConfigDir.mkdirs()

        buildConfigDir.resolve("DesktopBuildConfig.kt").writeText(
            """
            |package com.bookmark.bookmarkme
            |
            |object DesktopBuildConfig {
            |    const val VERSION_NAME = "$versionName"
            |    const val VERSION_CODE = $versionCode
            |    const val APP_NAME = "BookmarkMe"
            |}
            """.trimMargin(),
        )
    }
}

kotlin.sourceSets.named("jvmMain") {
    kotlin.srcDir(generateDesktopBuildConfig.map { it.outputs.files.singleFile })
}

tasks.named("compileKotlinJvm") { dependsOn(generateDesktopBuildConfig) }
