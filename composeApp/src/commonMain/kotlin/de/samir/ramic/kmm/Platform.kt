package de.samir.ramic.kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
