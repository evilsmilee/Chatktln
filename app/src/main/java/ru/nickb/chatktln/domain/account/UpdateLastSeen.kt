package ru.nickb.chatktln.domain.account

import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

class UpdateLastSeen @Inject constructor(private val accountRepository: AccountRepository):
    UseCase<None, None>() {

    override suspend fun run(params: None) = accountRepository.updateAccountLastSeen()

}