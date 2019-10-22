package ru.nickb.chatktln.data.account

import ru.nickb.chatktln.domain.account.AccountEntity
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None

interface AccountRemote {
    fun register(email: String, name: String, password: String, token: String, userDate: Long): Either<Failure, None>

    fun login(email: String, password: String, token: String): Either<Failure, AccountEntity>

    fun updateToken(userId: Long, token: String, oldToken: String): Either<Failure, None>
}