package ru.nickb.chatktln.domain.friends

import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None

/*Методы для взаимодействия с друзьями*/

interface FriendsRepository {
    fun getFriends(): Either<Failure, List<FriendEntity>>
    fun getFriendRequests(): Either<Failure, List<FriendEntity>>
    fun approveFriendRequest(friendEntity: FriendEntity): Either<Failure, None>
    fun cancelFriendRequest(friendEntity: FriendEntity): Either<Failure, None>
    fun addFriend(email: String): Either<Failure, None>
    fun deleteFriend(friendEntity: FriendEntity): Either<Failure, None>
}