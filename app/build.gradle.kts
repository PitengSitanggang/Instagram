plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.instagram"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.instagram"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
        implementation("androidx.core:core-ktx:1.13.1")
        implementation("androidx.appcompat:appcompat:1.7.0")
        implementation("com.google.android.material:material:1.12.0")

        implementation(platform("androidx.compose:compose-bom:2024.10.00"))
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.material3:material3")
        implementation("androidx.compose.material:material") // TAMBAHKAN INI!
        implementation("androidx.activity:activity-compose:1.9.3")
        implementation("androidx.compose.ui:ui-tooling-preview")

        implementation("com.google.accompanist:accompanist-pager:0.32.0")
        implementation("com.google.accompanist:accompanist-pager-indicators:0.32.0")
        implementation("androidx.navigation:navigation-compose:2.7.7")
        implementation("androidx.compose.material:material-icons-extended:1.6.3")

        // HAPUS BARIS INI (duplikat dan error)
        // implementation(libs.androidx.navigation.compose.android)

        testImplementation("junit:junit:4.13.2")
        debugImplementation("androidx.compose.ui:ui-tooling")

}
