package ru.nickb.chatktln.presentation

import ru.nickb.chatktln.domain.account.CheckAuth
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Authenticator @Inject constructor(val checkAuth: CheckAuth) {
    fun userLoggedIn(body: (Boolean) -> Unit) {
        checkAuth(None()) {
         it.either({body(false)}, {body(it)})
        }
    }
}