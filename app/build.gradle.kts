plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
}

android {
    namespace = "gb.com.educational_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "gb.com.educational_app"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation (project(":home"))
    implementation (project(":core"))
    implementation (project(":classes"))
    implementation (project(":favorites"))
    implementation (project(":progress"))
    implementation (project(":data_provider"))
    //Kotlin
    implementation ("androidx.core:core-ktx:1.12.0")

    //AndroidX
    implementation ("androidx.appcompat:appcompat:1.6.1")

    //Design
    implementation ("com.google.android.material:material:1.10.0")

    //Test
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    //Koin
    implementation ("io.insert-koin:koin-android:3.4.2")
    implementation ("io.insert-koin:koin-core:3.4.2")
    implementation ("io.insert-koin:koin-androidx-navigation:3.4.0")
    implementation ("io.insert-koin:koin-androidx-compose:3.4.0")

    //BottomNavigationBar
    implementation ("com.github.ismaeldivita:chip-navigation-bar:1.4.0")
}