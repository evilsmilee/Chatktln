package ru.nickb.chatktln.domain.friends

import com.google.gson.annotations.SerializedName
import javax.inject.Inject

/*Модельный класс. Содержит данные друга*/

class FriendEntity @Inject constructor(
    @SerializedName("user_id")
    val id: Long,
    val name: String,
    val email: String,
    @SerializedName("friends_id")
    val friendsId: Long,
    val status: String,
    val image: String
)