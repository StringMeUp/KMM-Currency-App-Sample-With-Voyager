package de.samir.ramic.kmm.di

import de.samir.ramic.kmm.Description
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    singleOf(::Description)
}