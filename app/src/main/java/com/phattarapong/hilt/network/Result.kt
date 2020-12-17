package com.phattarapong.hilt.network

sealed class Result<out T : Any> {
    object Loading : Result<Nothing>()
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val msg: String) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Loading -> "Loading"
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$msg]"
        }
    }
}