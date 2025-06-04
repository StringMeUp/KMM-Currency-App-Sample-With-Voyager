package de.samir.ramic.kmm.data.endpoint

sealed interface Environment {
    val baseUrl: String

    data object Dev : Environment {
        //https://api.currencyapi.com/v3/latest?apikey=cur_live_awUg2sqOhEKqEoDU8UmCgocLt1X6fZaSMfzBEu3K
        override val baseUrl = "api.currencyapi.com"

    }

    data object Staging : Environment {
        override val baseUrl = "jsonplaceholder.typicode.com"
    }

    data object Prod : Environment {
        override val baseUrl = "jsonplaceholder.typicode.com"
    }
}