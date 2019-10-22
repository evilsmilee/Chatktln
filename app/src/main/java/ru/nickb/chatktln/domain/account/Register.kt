package ru.nickb.chatktln.domain.account

import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

class Register @Inject constructor(private val repository: AccountRepository): UseCase<None, Register.Params>() {


    override suspend fun run(params: Params): Either<Failure, None> {
        return repository.register(email = params.email, name = params.name, password = params.password)
    }


    data class Params(val email: String, val name: String, val password: String)


}


