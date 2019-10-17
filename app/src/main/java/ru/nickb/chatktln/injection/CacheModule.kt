package ru.nickb.chatktln.injection

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import ru.nickb.chatktln.cache.AccountCacheImpl
import ru.nickb.chatktln.cache.SharedPrefsManager
import ru.nickb.chatktln.data.Account.AccountCache
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
}