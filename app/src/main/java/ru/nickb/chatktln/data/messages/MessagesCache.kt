package ru.nickb.chatktln.data.messages

import ru.nickb.chatktln.domain.messages.MessageEntity

interface MessagesCache {
    fun saveMessage(entity: MessageEntity)

    fun getChats(): List<MessageEntity>

    fun getMessagesWithContact(contactId: Long): List<MessageEntity>

}