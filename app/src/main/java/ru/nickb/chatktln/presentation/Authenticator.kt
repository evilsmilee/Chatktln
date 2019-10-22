package ru.nickb.chatktln.presentation

import ru.nickb.chatktln.cache.SharedPrefsManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Authenticator @Inject constructor(val sharedPrefsManager: SharedPrefsManager) {
    fun userLoggedIn() = sharedPrefsManager.contatintsAnyAccount()
}