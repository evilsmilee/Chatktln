package ru.nickb.chatktln.injection

import dagger.Module
import dagger.Provides
import ru.nickb.chatktln.BuildConfig
import ru.nickb.chatktln.data.account.AccountRemote
import ru.nickb.chatktln.data.friends.FriendsRemote
import ru.nickb.chatktln.remote.account.AccountRemoteImpl
import ru.nickb.chatktln.remote.core.Request
import ru.nickb.chatktln.remote.friends.FriendsRemoteImpl
import ru.nickb.chatktln.remote.service.ApiService
import ru.nickb.chatktln.remote.service.ServiceFactory
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun providesApiService(): ApiService = ServiceFactory.makeService(BuildConfig.DEBUG)

    @Singleton
    @Provides
    fun provideAccountRemote(request: Request, apiService: ApiService): AccountRemote {
        return AccountRemoteImpl(request, apiService)
    }

    @Singleton
    @Provides
    fun provideFriendsRemote(request: Request, apiService: ApiService): FriendsRemote {
        return FriendsRemoteImpl(request, apiService)
    }
}