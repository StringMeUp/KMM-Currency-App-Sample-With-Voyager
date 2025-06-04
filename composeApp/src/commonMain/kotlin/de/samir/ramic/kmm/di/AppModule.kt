package de.samir.ramic.kmm.di

fun appModule() = listOf(
    commonModule,
    platformModule,
    environmentModule,
    networkModule,
    repositoryModule,
    viewModelModule
)