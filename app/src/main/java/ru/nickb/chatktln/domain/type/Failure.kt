package ru.nickb.chatktln.domain.type

//Класс маркер. Передача маркеров об ошибке.

sealed class Failure {

    object NetworkConnectionError: Failure()
    object ServerError: Failure()
    object AuthError: Failure()
    object TokenError: Failure()

    object EmailAlreadyExistError: Failure()

    object NoSavedAccountsError: Failure()

    object AlreadyFriendError: Failure()
    object AlreadyRequestedFriendError: Failure()
    object ContactNotFoundError: Failure()

    object FilePickError: Failure()

    object EmailNotRegisteredError: Failure()
    object CantSendEmailError: Failure()
}