package com.bookmark.bookmarkme.core.model

sealed class Output<out TModel : Any> {
    data class Success<out TModel : Any>(
        val model: TModel,
    ) : Output<TModel>()

    data class Failure(
        val throwable: Throwable,
    ) : Output<Nothing>()

    fun asSuccess(): Output<TModel> = this as Success<TModel>
}
