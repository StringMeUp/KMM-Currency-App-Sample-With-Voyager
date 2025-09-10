📱 Simple Currency App (Kotlin Multiplatform)

This is a simple currency app built with Kotlin Multiplatform, sharing both logic and UI between Android and iOS using Compose Multiplatform.
The app demonstrates core KMP principles along with a modern Compose-based approach to cross-platform UI development.

🗂️ Project Structure

/composeApp – shared code for Android and iOS (UI, business logic, dependency injection, networking).

commonMain → code common for all targets.

androidMain → platform-specific code for Android.

iosMain → platform-specific code for iOS (e.g., Apple CoreCrypto integration).

/iosApp – entry point for the iOS application.
Even when sharing UI with Compose Multiplatform, a native iOS project is still required.
This is also the place to add SwiftUI code if you want to combine it with Compose UI.

🛠️ Libraries & Technologies

The project uses modern libraries and tools:

Compose Multiplatform 1.8.1 → UI on Android & iOS

Ktor 2.3.12 → networking (OkHttp for Android, Darwin for iOS)

Koin 4.0.0 (+ annotations) → dependency injection

Voyager 1.1.0-beta02 → multiplatform navigation

kotlinx-datetime 0.7.1 → date & time utilities

bignum 0.3.10 → precise big number operations (currencies)

AndroidX Lifecycle & Activity Compose → Android lifecycle integration

kotlinx-serialization → JSON serialization

🚀 Build Info
Kotlin 2.1.21

Android Gradle Plugin 8.7.3

Android SDK: minSdk 24, targetSdk 35, compileSdk 35