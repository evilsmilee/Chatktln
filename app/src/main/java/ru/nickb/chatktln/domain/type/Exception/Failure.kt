package ru.nickb.chatktln.domain.type.Exception

sealed class Failure {

    object NetworkConnectionError: Failure()
    object ServerError: Failure()

}