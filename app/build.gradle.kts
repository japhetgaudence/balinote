plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("io.realm.kotlin")
    id("kotlin-parcelize")
    kotlin("plugin.serialization") version "1.9.10"
}

android {
    namespace = "com.balitech.balinote"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.balitech.balinote"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    kotlinOptions {
        jvmTarget = "19"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core UI
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("androidx.palette:palette-ktx:1.0.0")

    // Core Data
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    val composeVersion = "2023.08.00"
    implementation(platform("androidx.compose:compose-bom:$composeVersion"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material3:material3-window-size-class")

    val hiltVersion = "2.48"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    ksp("com.google.dagger:hilt-android-compiler:$hiltVersion")

    val hiltJetpackLibrariesVersion = "1.1.0"
    implementation("androidx.hilt:hilt-navigation-compose:$hiltJetpackLibrariesVersion")
    implementation("androidx.hilt:hilt-work:$hiltJetpackLibrariesVersion")
    ksp("androidx.hilt:hilt-compiler:$hiltJetpackLibrariesVersion")

    val navigationVersion = "2.7.6"
    implementation("androidx.navigation:navigation-compose:$navigationVersion")

    val lifeCycleVersion = "2.7.0"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifeCycleVersion")
    implementation("androidx.lifecycle:lifecycle-service:$lifeCycleVersion")

    val coroutinesVersion = "1.7.3"
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    val realmVersion = "1.11.0"
    implementation("io.realm.kotlin:library-base:$realmVersion")

    val datastoreVersion = "1.0.0"
    implementation("androidx.datastore:datastore:$datastoreVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5")

    val pagingVersion = "3.2.1"
    implementation("androidx.paging:paging-runtime-ktx:$pagingVersion")
    implementation("androidx.paging:paging-compose:3.3.0-alpha02")

    val workManagerVersion = "2.9.0"
    implementation("androidx.work:work-runtime-ktx:$workManagerVersion")

    /*
      !!! 3rd Party
    */

    // Navigation
    val raamcostaVersion = "1.10.0"
    implementation("io.github.raamcosta.compose-destinations:animations-core:$raamcostaVersion")
    ksp("io.github.raamcosta.compose-destinations:ksp:$raamcostaVersion")

    // Image Loader
    implementation("io.coil-kt:coil-compose:2.5.0")

    // Rich Text Editor
    implementation("com.mohamedrejeb.richeditor:richeditor-compose:1.0.0-rc01")

    // Shared Element Transition
    implementation("com.github.skydoves:orbital:0.3.4")

    // Date Time
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs_nio:2.0.4")

    // Logging
    implementation ("com.jakewharton.timber:timber:5.0.1")


    /*
      !!! Testing
    */

    // Local Tests.
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    // Instrumentation Tests
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // UI Tests
    androidTestImplementation(platform("androidx.compose:compose-bom:$composeVersion"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}