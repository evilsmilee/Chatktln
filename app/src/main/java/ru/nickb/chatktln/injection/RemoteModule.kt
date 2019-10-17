package ru.nickb.chatktln.injection

import android.app.DownloadManager
import dagger.Module
import dagger.Provides
import ru.nickb.chatktln.BuildConfig
import ru.nickb.chatktln.data.Account.AccountRemote
import ru.nickb.chatktln.remote.account.AccountRemoteImpl
import ru.nickb.chatktln.remote.core.Request
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

}