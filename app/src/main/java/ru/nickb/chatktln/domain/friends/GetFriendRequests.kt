package ru.nickb.chatktln.domain.friends

import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

class GetFriendRequests @Inject constructor(private val friendsRepository: FriendsRepository): UseCase<List<FriendEntity>, None>() {

    override suspend fun run(params: None): Either<Failure, List<FriendEntity>> = friendsRepository.getFriendRequests()




}