package ru.nickb.chatktln.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.nickb.chatktln.data.account.AccountCache
import ru.nickb.chatktln.data.account.AccountRemote
import ru.nickb.chatktln.data.account.AccountRepositoryImpl
import ru.nickb.chatktln.data.friends.FriendsCache
import ru.nickb.chatktln.data.friends.FriendsRemote
import ru.nickb.chatktln.data.friends.FriendsRepositoryImpl
import ru.nickb.chatktln.data.media.MediaRepositoryImpl
import ru.nickb.chatktln.data.messages.MessagesCache
import ru.nickb.chatktln.data.messages.MessagesRemote
import ru.nickb.chatktln.data.messages.MessagesRepositoryImpl
import ru.nickb.chatktln.domain.account.AccountRepository
import ru.nickb.chatktln.domain.friends.FriendsRepository
import ru.nickb.chatktln.domain.media.MediaRepository
import ru.nickb.chatktln.domain.messages.MessagesRepository
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
    fun provideFriendsRepository(remote: FriendsRemote, accountCache: AccountCache, friendsCache: FriendsCache): FriendsRepository {
        return FriendsRepositoryImpl(accountCache, remote, friendsCache)
    }

    @Provides
    @Singleton
    fun provideMediaRepository(context: Context): MediaRepository {
        return MediaRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideMessagesRepository(remote: MessagesRemote, cache: MessagesCache, accountCache: AccountCache) : MessagesRepository {
        return MessagesRepositoryImpl(remote, cache, accountCache)
    }

}