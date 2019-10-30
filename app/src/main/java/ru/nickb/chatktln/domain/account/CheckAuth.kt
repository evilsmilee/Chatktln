package ru.nickb.chatktln.domain.account

import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

class CheckAuth @Inject constructor(private val repository: AccountRepository): UseCase<Boolean, None>() {

    override suspend fun run(params: None): Either<Failure, Boolean> = repository.checkAuth()
}