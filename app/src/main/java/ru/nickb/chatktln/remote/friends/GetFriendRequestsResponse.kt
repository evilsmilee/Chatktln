package ru.nickb.chatktln.remote.friends

import com.google.gson.annotations.SerializedName
import ru.nickb.chatktln.domain.friends.FriendEntity
import ru.nickb.chatktln.remote.core.BaseResponse

class GetFriendRequestsResponse (
    success: Int,
    message: String,
    @SerializedName("friend_requests")
    val friendsRequests: List<FriendEntity>
) : BaseResponse(success, message)