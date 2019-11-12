package ru.nickb.chatktln.domain.messages

import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None

interface MessagesRepository {
    fun sendMessage(
        toId: Long,
        message: String,
        image: String
    ): Either<Failure, None>

    fun getChats(needFetch: Boolean): Either<Failure, List<MessageEntity>>

    fun getMessagesWithContact(contactId: Long, needFetch: Boolean): Either<Failure, List<MessageEntity>>

    fun deleteMessagesByUser(messageId: Long): Either<Failure, None>
}