package ru.nickb.chatktln.domain.account

import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Exception.Failure
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

class UpdateToken @Inject constructor(private val accountRepository: AccountRepository): UseCase<None, UpdateToken.Params>() {

    override suspend fun run(params: UpdateToken.Params): Either<Failure, None> = accountRepository.updateAccountToken(params.token)

    data class Params(val token: String)

}