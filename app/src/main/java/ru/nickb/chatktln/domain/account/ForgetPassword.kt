package ru.nickb.chatktln.domain.account

import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

class ForgetPassword @Inject constructor(private val accountRepository: AccountRepository): UseCase<None, ForgetPassword.Params>() {


    override suspend fun run(params: Params): Either<Failure, None> = accountRepository.forgetPassword(params.email)

    data class Params(val email: String)

}