package ru.nickb.chatktln.domain.friends

import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

/*Use case for add friend*/

class AddFriend @Inject constructor(
    private val friendsRepository: FriendsRepository
): UseCase<None, AddFriend.Params>() {

    override suspend fun run(params: AddFriend.Params): Either<Failure, None> = friendsRepository.addFriend(params.email)

    data class Params(val email: String)
}