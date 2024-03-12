plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-parcelize")
}

android {
    namespace = "com.example.rickandmortyapi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.rickandmortyapi"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

   viewBinding {
       enable = true
   }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    //RETROFIT
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //IMAGE CONSUMER
    implementation("com.github.bumptech.glide:glide:4.15.1")
    implementation("org.jetbrains.kotlin:kotlin-test:1.8.22")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.13.2")
    //SHIMMER
    implementation("com.facebook.shimmer:shimmer:0.5.0")
    //NAVIGATION
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    testImplementation("io.mockk:mockk:1.12.4")
    testImplementation("junit:junit:4.13.2")
    // JSON Converter
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.timber:timber:5.0.1")
    //VIEWMODEL
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    //KOIN IMPLEMENTATION
    implementation("io.insert-koin:koin-android:3.4.0")
    //NAVIGATION
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    implementation("androidx.core:core-splashscreen:1.0.1")

    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.test:core-ktx:1.5.0")
    androidTestUtil ("androidx.test:orchestrator:1.4.2")
    testImplementation ("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    testImplementation ("org.mockito:mockito-core:4.0.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    testImplementation ("android.arch.core:core-testing:1.1.1")
    testImplementation("org.powermock:powermock-api-mockito2:2.0.9")
    testImplementation("org.powermock:powermock-module-junit4:2.0.9")
}