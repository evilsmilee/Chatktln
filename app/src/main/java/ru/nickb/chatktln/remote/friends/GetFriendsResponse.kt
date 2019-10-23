package ru.nickb.chatktln.remote.friends

import ru.nickb.chatktln.domain.friends.FriendEntity
import ru.nickb.chatktln.remote.core.BaseResponse

class GetFriendsResponse(success: Int, message: String, val friends: List<FriendEntity>): BaseResponse(success, message)