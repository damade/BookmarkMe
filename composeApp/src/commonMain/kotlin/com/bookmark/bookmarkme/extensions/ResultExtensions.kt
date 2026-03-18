package com.bookmark.bookmarkme.extensions

import com.bookmark.bookmarkme.core.model.Output
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
fun <T : Any> Output<T>.successModelOrNull(): T? {
    contract {
        returnsNotNull() implies (this@successModelOrNull is Output.Success)
    }
    return (this as? Output.Success)?.model
}

inline fun <ResponseModel : Any, OutputModel : Any> Output<ResponseModel>.map(
    mapper: (model: ResponseModel) -> OutputModel,
): Output<OutputModel> =
    when (this) {
        is Output.Success ->
            Output.Success(
                model = mapper(model),
            )
        is Output.Failure -> Output.Failure(throwable = throwable)
    }

fun <T : Any> Output<T>.successModelOrFallback(fallback: T): T =
    when (this) {
        is Output.Success -> this.model
        else -> fallback
    }

@OptIn(ExperimentalContracts::class)
fun <T : Any> Output<T>.isSuccess(): Boolean {
    contract {
        returns(true) implies (this@isSuccess is Output.Success)
    }
    return this is Output.Success
}

@OptIn(ExperimentalContracts::class)
fun <T : Any> Output<T>.isFailure(): Boolean {
    contract {
        returns(true) implies (this@isFailure is Output.Failure)
    }
    return this is Output.Failure
}

suspend fun <R : Any> runCatchingResult(block: suspend () -> R): Output<R> =
    runCatching {
        Output.Success(model = block())
    }.getOrElse { throwable ->
        currentCoroutineContext().ensureActive()
        Output.Failure(throwable = throwable)
    }

suspend fun <R : Any> runAsResult(block: suspend () -> Output<R>): Output<R> =
    try {
        block()
    } catch (throwable: Throwable) {
        currentCoroutineContext().ensureActive()
        Output.Failure(throwable = throwable)
    }

inline fun <T : Any> Output<T>.onSuccess(action: (T) -> Unit): Output<T> {
    if (this is Output.Success) {
        action(model)
    }
    return this
}

inline fun <T : Any> Output<T>.onSuccessIf(
    condition: (T) -> Boolean,
    action: (T) -> Unit,
): Output<T> {
    if (this is Output.Success && condition(model)) {
        action(model)
    }
    return this
}

inline fun <T : Any> Output<T>.onFailure(action: (Throwable) -> Unit): Output<T> {
    if (this is Output.Failure) {
        action(throwable)
    }
    return this
}

fun Throwable.toFailureOutput(): Output<Nothing> = Output.Failure(throwable = this)

fun <T : Any> T.toSuccessOutput(): Output<T> = Output.Success(model = this)

fun <T : Any> Flow<T>.mapOutput(): Flow<Output<T>> =
    map<T, Output<T>> {
        Output.Success(model = it)
    }.catch {
        emit(Output.Failure(throwable = it))
    }
