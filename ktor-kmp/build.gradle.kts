plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.serialization)
}

group = "com.softmoon"
version = "0.0.1"

kotlin {
    jvm {
        withJava()
    }
    js(IR) {
        binaries.library()
        moduleName = "kmp-js-lib"
        browser {
            webpackTask {
                mainOutputFileName = "kmp-js-lib"
                output.library = "kmp-js-lib"
            }
        }
        generateTypeScriptDefinitions()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.client.logging)
                implementation(libs.ktor.client.encoding)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.ktor.serialization.kotlinx.json)
            }
        }
        jvmMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }
        val jsMain by getting {
            dependencies {
                implementation(libs.ktor.client.js)
            }
        }

        all {
            languageSettings.apply {
                optIn("kotlin.js.ExperimentalJsExport")
                optIn("kotlinx.coroutines.DelicateCoroutinesApi")
            }
        }

    }
}

tasks.named("jsBrowserProductionLibraryPrepare") {
    dependsOn("jsProductionLibraryCompileSync")
}

