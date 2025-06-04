package de.samir.ramic.kmm

import platform.Foundation.NSBundle
import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

/** example expect class */
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class KoinPlatform actual constructor() {
    actual val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getHttpClientProvider(): HttpClientProvider {
    return IOSHttpClient()
}

actual fun getApiKey(): String {
    val key = NSBundle.mainBundle.infoDictionary?.get("API_KEY") as? String
    return key ?: error("API_KEY not found in Info.plist")
}