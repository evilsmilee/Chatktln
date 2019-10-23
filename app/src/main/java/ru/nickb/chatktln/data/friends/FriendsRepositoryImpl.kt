package ru.nickb.chatktln.data.friends

import ru.nickb.chatktln.data.account.AccountCache
import ru.nickb.chatktln.domain.friends.FriendEntity
import ru.nickb.chatktln.domain.friends.FriendsRepository
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None
import ru.nickb.chatktln.domain.type.flatMap
import javax.inject.Inject

/*Реализация методов интерфейса*/

class FriendsRepositoryImpl @Inject constructor(private val accountCache: AccountCache, private val friendsRemote: FriendsRemote): FriendsRepository {

    override fun getFriends(): Either<Failure, List<FriendEntity>> {
       return accountCache.getCurrentAccount()
           .flatMap { friendsRemote.getFriends(it.id, it.token) }
    }

    override fun getFriendRequests(): Either<Failure, List<FriendEntity>> {
        return accountCache.getCurrentAccount()
            .flatMap { friendsRemote.getFriendRequests(userId = it.id, token = it.token) }
    }

    override fun approveFriendRequest(friendEntity: FriendEntity): Either<Failure, None> {
        return accountCache.getCurrentAccount()
            .flatMap { friendsRemote.approveFriendRequst(userId = it.id, requestUserId = friendEntity.id, friendsId = friendEntity.friendsId, token = it.token) }
    }

    override fun cancelFriendRequest(friendEntity: FriendEntity): Either<Failure, None> {
       return accountCache.getCurrentAccount()
           .flatMap { friendsRemote.cancelFriendRequest(userId = it.id, requestUserId = friendEntity.id, friendsId = friendEntity.friendsId, token = it.token) }
    }

    override fun addFriend(email: String): Either<Failure, None> {
        return accountCache.getCurrentAccount()
            .flatMap { friendsRemote.addFriend(userId = it.id, email = email, token = it.token ) }
    }

    override fun deleteFriend(friendEntity: FriendEntity): Either<Failure, None> {
       return accountCache.getCurrentAccount()
           .flatMap { friendsRemote.deleteFriend(it.id, friendEntity.id, friendEntity.friendsId, it.token) }
    }

}