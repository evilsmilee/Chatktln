package ru.nickb.chatktln.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.nickb.chatktln.data.account.AccountCache
import ru.nickb.chatktln.data.account.AccountRemote
import ru.nickb.chatktln.data.account.AccountRepositoryImpl
import ru.nickb.chatktln.data.friends.FriendsRemote
import ru.nickb.chatktln.data.friends.FriendsRepositoryImpl
import ru.nickb.chatktln.domain.account.AccountRepository
import ru.nickb.chatktln.domain.friends.FriendsRepository
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

    @Provides
    @Singleton
    fun provideFriendsRepository(remote: FriendsRemote, cache: AccountCache): FriendsRepository {
        return FriendsRepositoryImpl(cache, remote)
    }
}