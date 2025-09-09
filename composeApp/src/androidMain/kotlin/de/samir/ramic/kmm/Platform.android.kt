package de.samir.ramic.kmm

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

/** example expect class */
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class KoinPlatform actual constructor() {
    actual val name: String
        get() = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getHttpClientProvider(): HttpClientProvider {
    return AndroidHttpClient()
}

actual fun getApiKey(): String {
    return BuildConfig.API_KEY
}
