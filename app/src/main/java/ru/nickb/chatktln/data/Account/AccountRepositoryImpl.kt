package ru.nickb.chatktln.data.Account

import ru.nickb.chatktln.domain.account.AccountEntity
import ru.nickb.chatktln.domain.account.AccountRepository
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Exception.Failure
import ru.nickb.chatktln.domain.type.None
import ru.nickb.chatktln.domain.type.flatMap
import java.util.*

class AccountRepositoryImpl(private val accountRemote: AccountRemote, private val accountCache: AccountCache): AccountRepository {

    override fun login(email: String, password: String): Either<Failure, AccountEntity> {
        throw UnsupportedOperationException("Login is not supported")
    }

    override fun logout(): Either<Failure, None> {
        throw UnsupportedOperationException("Logout is not supported")
    }

    override fun register(email: String, name: String, password: String): Either<Failure, None> {
        return accountCache.getToken().flatMap {
            accountRemote.register(email = email, name = name, password = password, token = it, userDate = Calendar.getInstance().timeInMillis)
        }
    }

    override fun forgetPassword(email: String): Either<Failure, None> {
        throw UnsupportedOperationException("Password recovery is not supported")
    }

    override fun getCurrentAccount(): Either<Failure, AccountEntity> {
        throw UnsupportedOperationException("Get account is not supported")
    }

    override fun updateAccountToken(token: String): Either<Failure, None> {
        return accountCache.saveToken(token)
    }

    override fun upateAccountLastSeen(): Either<Failure, None> {
        throw UnsupportedOperationException("Updating last seen is not supported")
    }

    override fun editAccount(entity: AccountEntity): Either<Failure, AccountEntity> {
        throw UnsupportedOperationException("Editing account is not supported")
    }
}