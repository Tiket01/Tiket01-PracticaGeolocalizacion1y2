plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.geolocalizacionapp"
    compileSdk = 34

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.example.geolocalizacionapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // API Key para Google Maps
        val googleMapsApiKey: String = project.findProperty("GOOGLE_MAPS_API_KEY") as String? ?: ""
        buildConfigField("String", "GOOGLE_MAPS_API_KEY", "\"$googleMapsApiKey\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Dependencias para Retrofit y Gson
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)

    // Logging Interceptor de OkHttp
    implementation(libs.logging.interceptor)

    // Maps
    implementation(libs.play.services.maps)

    // Dependencias para Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.2.1")
}
