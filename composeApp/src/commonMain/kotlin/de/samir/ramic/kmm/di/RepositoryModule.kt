package de.samir.ramic.kmm.di

import de.samir.ramic.kmm.data.RequestHandler
import de.samir.ramic.kmm.data.api.ApiService
import de.samir.ramic.kmm.data.repository.RepositoryImpl
import de.samir.ramic.kmm.domain.repository.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single<Repository> {
        val requestHandler: RequestHandler = get()
        val api: ApiService = get()
        RepositoryImpl(requestHandler, api)
    }
}