package ru.nickb.chatktln.remote.messages

import ru.nickb.chatktln.domain.messages.MessageEntity
import ru.nickb.chatktln.remote.core.BaseResponse

class GetMessagesResponse(
    success: Int,
    message: String,
    val messages: List<MessageEntity>
) : BaseResponse(success, message)