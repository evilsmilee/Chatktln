package ru.nickb.chatktln.domain.messages

import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

class DeleteMessage @Inject constructor(private val messagesRepository: MessagesRepository): UseCase<None, DeleteMessage.Params>() {

    override suspend fun run(params: Params) = messagesRepository.deleteMessagesByUser(params.messageId)

    data class Params(val messageId: Long)
}