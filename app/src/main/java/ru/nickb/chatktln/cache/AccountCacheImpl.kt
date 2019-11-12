package ru.nickb.chatktln.cache

import ru.nickb.chatktln.data.account.AccountCache
import ru.nickb.chatktln.domain.account.AccountEntity
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

class AccountCacheImpl @Inject constructor(private val prefsManager: SharedPrefsManager, private val chatDatabase: ChatDatabase): AccountCache {


    override fun getToken(): Either<Failure, String> {
        return prefsManager.getToken()
    }

    override fun saveToken(token: String): Either<Failure, None> {
        return prefsManager.saveToken(token = token)
    }

    override fun logout(): Either<Failure, None> {
        chatDatabase.clearAllTables()
        return prefsManager.removeAccount()
    }

    override fun getCurrentAccount(): Either<Failure, AccountEntity> {
        return prefsManager.getAccount()
    }

    override fun saveAccount(account: AccountEntity): Either<Failure, None> {
        return prefsManager.saveAccount(account)
    }

    override fun checkAuth(): Either<Failure, Boolean> {
        return prefsManager.contatintsAnyAccount()
    }
}