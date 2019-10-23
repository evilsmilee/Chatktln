package ru.nickb.chatktln.domain.friends

import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

class DeleteFriend @Inject constructor(private val friendsRepository: FriendsRepository): UseCase<None, FriendEntity>() {

    override suspend fun run(params: FriendEntity) = friendsRepository.deleteFriend(params)


}