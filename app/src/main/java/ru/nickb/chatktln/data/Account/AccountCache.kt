package ru.nickb.chatktln.data.Account

import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Exception.Failure
import ru.nickb.chatktln.domain.type.None

interface AccountCache {

    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>
}