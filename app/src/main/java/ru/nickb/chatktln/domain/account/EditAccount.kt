package ru.nickb.chatktln.domain.account

import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import javax.inject.Inject

class EditAccount @Inject constructor(private val repository: AccountRepository): UseCase<AccountEntity, AccountEntity>() {

    override suspend fun run(params: AccountEntity): Either<Failure, AccountEntity> = repository.editAccount(params)
}