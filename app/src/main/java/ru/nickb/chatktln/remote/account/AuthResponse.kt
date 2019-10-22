package ru.nickb.chatktln.remote.account

import ru.nickb.chatktln.domain.account.AccountEntity
import ru.nickb.chatktln.remote.core.BaseResponse

class AuthResponse(
    success: Int,
    message: String,
    val user: AccountEntity
) : BaseResponse(success, message)