package ru.nickb.chatktln.data.messages

import ru.nickb.chatktln.domain.messages.MessageEntity
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None

interface MessagesRemote {
    fun getChats(userId: Long, token: String): Either<Failure, List<MessageEntity>>

    fun getMessagesWithContact(contactId: Long, userId: Long, token: String): Either<Failure, List<MessageEntity>>

    fun sendMessage(
        fromId: Long,
        toId: Long,
        token: String,
        message: String,
        image: String
    ): Either<Failure, None>

    fun deleteMessagesByUser(userId: Long, messagesId: Long, token: String): Either<Failure, None>
}