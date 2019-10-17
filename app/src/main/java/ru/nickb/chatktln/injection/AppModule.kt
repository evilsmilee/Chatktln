package ru.nickb.chatktln.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.nickb.chatktln.data.Account.AccountCache
import ru.nickb.chatktln.data.Account.AccountRemote
import ru.nickb.chatktln.data.Account.AccountRepositoryImpl
import ru.nickb.chatktln.domain.account.AccountRepository
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = context

    @Provides
    @Singleton
    fun provideAccountRepository(remote: AccountRemote, cache: AccountCache): AccountRepository {
        return AccountRepositoryImpl(remote, cache)
    }
}