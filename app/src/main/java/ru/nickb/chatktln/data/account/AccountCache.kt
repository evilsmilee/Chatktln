package ru.nickb.chatktln.data.account

import ru.nickb.chatktln.domain.account.AccountEntity
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None

interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>

    fun logout(): Either<Failure, None>

    fun getCurrentAccount(): Either<Failure, AccountEntity>
    fun saveAccount(account: AccountEntity): Either<Failure, None>

    fun checkAuth(): Either<Failure, Boolean>
}