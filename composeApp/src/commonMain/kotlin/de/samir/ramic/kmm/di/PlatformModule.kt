package de.samir.ramic.kmm.di

import de.samir.ramic.kmm.KoinPlatform
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val platformModule = module {
    singleOf(::KoinPlatform)
}