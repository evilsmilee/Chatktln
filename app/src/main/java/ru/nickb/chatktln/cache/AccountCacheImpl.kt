package ru.nickb.chatktln.cache

import ru.nickb.chatktln.data.Account.AccountCache
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Exception.Failure
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

class AccountCacheImpl @Inject constructor(private val prefsManager: SharedPrefsManager): AccountCache {

    override fun getToken(): Either<Failure, String> {
        return prefsManager.getToken()
    }

    override fun saveToken(token: String): Either<Failure, None> {
        return prefsManager.saveToken(token = token)
    }
}