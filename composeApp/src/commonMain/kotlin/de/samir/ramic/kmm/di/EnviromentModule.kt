package de.samir.ramic.kmm.di
import de.samir.ramic.kmm.data.endpoint.AppEnvironment
import de.samir.ramic.kmm.data.endpoint.Environment
import org.koin.core.module.Module
import org.koin.dsl.module

val environmentModule: Module = module {
    single<Environment> { AppEnvironment.current }
}