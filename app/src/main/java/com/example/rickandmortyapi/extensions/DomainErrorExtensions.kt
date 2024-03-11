package com.example.rickandmortyapi.extensions

import com.example.rickandmortyapi.utils.AuthenticationException
import com.example.rickandmortyapi.utils.UnexpectedException
import retrofit2.HttpException

internal fun <T> Result<T>.getOrThrowDomainError(): T {
    return getOrElse { throw it.toDomainError() }
}

internal fun Throwable.toDomainError(): Throwable {
    return when (this) {
        is HttpException -> {
            when (code()) {
                401 -> AuthenticationException
                else -> UnexpectedException(message())
            }
        }
        else -> this
    }
}
