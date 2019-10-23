package ru.nickb.chatktln.data.friends

import ru.nickb.chatktln.domain.friends.FriendEntity
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None

/*Интерфейс содержащий функции для взаимодействия с друзьями на сервере*/

interface FriendsRemote {
    fun getFriends(userId: Long, token: String): Either<Failure, List<FriendEntity>>
    fun getFriendRequests(userId: Long, token: String): Either<Failure, List<FriendEntity>>
    fun approveFriendRequst(userId: Long, requestUserId: Long, friendsId: Long, token: String): Either<Failure, None>
    fun cancelFriendRequest(userId: Long, requestUserId: Long, friendsId: Long, token: String): Either<Failure, None>
    fun addFriend(userId: Long, email: String, token: String): Either<Failure, None>
    fun deleteFriend(userId: Long, requestUserId: Long, friendsId: Long, token: String): Either<Failure, None>
}