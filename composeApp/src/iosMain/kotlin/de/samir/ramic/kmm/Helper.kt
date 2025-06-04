package de.samir.ramic.kmm


import de.samir.ramic.kmm.di.appModule
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(appModule())
    }
}