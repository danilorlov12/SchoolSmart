package com.example.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withTimeoutOrNull

inline fun <T> stateFlow(crossinline fetchData: suspend () -> T): Flow<State<T>> {
    return flow {
        emit(State.loading())
        withTimeoutOrNull(5000L) {
            emit(State.success(fetchData()))
        }
    }.catch { e ->
        when (e) {
            is TimeoutCancellationException -> emit(State.failed("Timeout"))
            else -> emit(State.failed(e.message ?: "Error"))
        }
    }.flowOn(Dispatchers.Default)
}