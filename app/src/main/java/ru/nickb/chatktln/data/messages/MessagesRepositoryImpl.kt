package ru.nickb.chatktln.data.messages

import ru.nickb.chatktln.data.account.AccountCache
import ru.nickb.chatktln.domain.messages.MessageEntity
import ru.nickb.chatktln.domain.messages.MessagesRepository
import ru.nickb.chatktln.domain.type.*
import javax.inject.Inject

class MessagesRepositoryImpl @Inject constructor(
    private val messagesRemote: MessagesRemote,
    private val messagesCache: MessagesCache,
    private val accountCache: AccountCache
) : MessagesRepository {

    /*Вызывает из бд текущего пользователя для получения id и токена, преобразовывает сущность акк в сущность сообщения
    * с помощью мапы проверяет значение нидфетч если истина загружаются чаты и сохраняются в бд, если ложь загрузка из бд.*/
    override fun getChats(needFetch: Boolean): Either<Failure, List<MessageEntity>> {
        return accountCache.getCurrentAccount().flatMap { account ->
            return@flatMap if (needFetch) {
                messagesRemote.getChats(account.id, account.token).onNext {
                    it.map { message ->
                        if (message.senderId == account.id) {
                            message.fromMe = true
                        }
                    }
                    messagesCache.saveMessages(it)
                }
            } else {
                Either.Right(messagesCache.getChats())
            }
        }
            .map {
                it.distinctBy {
                    it.contact?.id
                }
            }
    }

    override fun getMessagesWithContact(
        contactId: Long,
        needFetch: Boolean
    ): Either<Failure, List<MessageEntity>> {
        return accountCache.getCurrentAccount().flatMap { account ->
            return@flatMap if (needFetch) {
                messagesRemote.getMessagesWithContact(contactId, account.id, account.token).onNext {
                    it.map { message ->

                        if (message.senderId == account.id) {
                            message.fromMe = true
                        }

                        val contact =
                            messagesCache.getChats().firstOrNull { it.contact?.id == contactId }?.contact
                        message.contact = contact
                    }
                    messagesCache.saveMessages(it)
                }
            } else {
                Either.Right(messagesCache.getMessagesWithContact(contactId))
            }
        }
    }

    override fun sendMessage(toId: Long, message: String, image: String): Either<Failure, None> {
        return accountCache.getCurrentAccount().flatMap {
            messagesRemote.sendMessage(it.id, toId, it.token, message, image)
        }
    }

    override fun deleteMessagesByUser(messageId: Long): Either<Failure, None> {
        return accountCache.getCurrentAccount().flatMap {
            messagesCache.deleteMessagesByUser(messageId)
            messagesRemote.deleteMessagesByUser(it.id, messageId, it.token)
        }
    }

}