package ru.nickb.chatktln.data.Account

import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Exception.Failure
import ru.nickb.chatktln.domain.type.None

interface AccountRemote {
    fun register(email: String, name: String, password: String, token: String, userDate: Long): Either<Failure, None>
}