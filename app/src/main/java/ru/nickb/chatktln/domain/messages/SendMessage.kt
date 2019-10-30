package ru.nickb.chatktln.domain.messages

import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

class SendMessage @Inject constructor(private val messagesRepository: MessagesRepository): UseCase<None, SendMessage.Params>() {

    override suspend fun run(params: Params): Either<Failure, None> = messagesRepository.sendMessage(params.told, params.message, params.image)

        data class Params(val told: Long, val message: String, val image: String)
}