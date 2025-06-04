package de.samir.ramic.kmm.di

import de.samir.ramic.kmm.ui.MainScreenModel
import org.koin.dsl.module

val viewModelModule = module {
    single { MainScreenModel(get()) }
}