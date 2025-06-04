package de.samir.ramic.kmm.data

import kotlinx.coroutines.CancellationException

class RequestHandler {
    suspend inline fun <T> makeSafeApiCall(
        crossinline block: suspend () -> T
    ): Result<T> {
        return try {
            Result.success(block())
        } catch (e: CancellationException) {
            println("❌ Coroutine cancelled: ${e.message}")
            throw e
        } catch (e: Exception) {
            println("❌ API Exception: ${e.stackTraceToString()}")
            Result.failure(e)
        }
    }
}