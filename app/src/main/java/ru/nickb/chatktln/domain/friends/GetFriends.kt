package ru.nickb.chatktln.domain.friends

import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

//Переменная Boolean если true загрузка с сервера, false из бд.

class GetFriends @Inject constructor(private val friendsRepository: FriendsRepository): UseCase<List<FriendEntity>, Boolean>() {

    override suspend fun run(needFetch: Boolean) = friendsRepository.getFriends(needFetch)
}