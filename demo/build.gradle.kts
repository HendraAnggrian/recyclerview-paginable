plugins {
    android("application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(SDK_TARGET)
    buildToolsVersion(BUILD_TOOLS)
    defaultConfig {
        minSdkVersion(SDK_MIN)
        targetSdkVersion(SDK_TARGET)
        applicationId = "$RELEASE_GROUP.paginated.demo"
        versionCode = 1
        versionName = RELEASE_VERSION
    }
    sourceSets {
        getByName("main") {
            manifest.srcFile("AndroidManifest.xml")
            java.srcDirs("src")
            res.srcDir("res")
            resources.srcDir("src")
        }
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":$RELEASE_ARTIFACT"))
    implementation(kotlin("stdlib", VERSION_KOTLIN))

    implementation(androidx("core", "core-ktx", "$VERSION_ANDROIDX-alpha03"))
    implementation(androidx("appcompat", version = "$VERSION_ANDROIDX-alpha01"))
    implementation(androidx("coordinatorlayout", version = "$VERSION_ANDROIDX-alpha01"))
    implementation(androidx("recyclerview", version = "$VERSION_ANDROIDX-alpha01"))
    implementation(androidx("cardview", version = "1.0.0"))
    implementation(material("$VERSION_ANDROIDX-alpha02"))

    implementation(square("retrofit2", "adapter-rxjava2", VERSION_RETROFIT))
    implementation(square("retrofit2", "converter-gson", VERSION_RETROFIT))
    implementation(square("okhttp3", "logging-interceptor", VERSION_OKHTTP))

    implementation(rx("java", VERSION_RXJAVA))
    implementation(rx("kotlin", VERSION_RXKOTLIN))
    implementation(rx("android", VERSION_RXANDROID))

    implementation("de.hdodenhof:circleimageview:$VERSION_CIRCLEIMAGEVIEW")
}
