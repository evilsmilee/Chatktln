package ru.nickb.chatktln.injection

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import ru.nickb.chatktln.cache.AccountCacheImpl
import ru.nickb.chatktln.cache.ChatDatabase
import ru.nickb.chatktln.cache.SharedPrefsManager
import ru.nickb.chatktln.data.account.AccountCache
import ru.nickb.chatktln.data.friends.FriendsCache
import ru.nickb.chatktln.data.messages.MessagesCache
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun providesAccountCache(prefsManager: SharedPrefsManager): AccountCache = AccountCacheImpl(prefsManager)

    @Provides
    @Singleton
    fun provideChatDatabase(context: Context): ChatDatabase {
        return ChatDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideFriendsCache(chatDatabase: ChatDatabase): FriendsCache {
        return chatDatabase.friendsDao
    }

    @Provides
    @Singleton
    fun provideMessagesCache(chatDatabase: ChatDatabase): MessagesCache {
        return chatDatabase.messagesDao
    }
}