package ru.nickb.chatktln.ui

import android.app.Application
import dagger.Component
import ru.nickb.chatktln.domain.account.AccountEntity
import ru.nickb.chatktln.injection.AppModule
import ru.nickb.chatktln.injection.CacheModule
import ru.nickb.chatktln.injection.RemoteModule
import ru.nickb.chatktln.injection.ViewModelModule
import ru.nickb.chatktln.ui.account.AccountActivity
import ru.nickb.chatktln.ui.account.AccountFragment
import ru.nickb.chatktln.ui.core.navigation.RouteActivity
import ru.nickb.chatktln.ui.register.RegisterActivity
import ru.nickb.chatktln.ui.register.RegisterFragment
import ru.nickb.chatktln.ui.firebase.FirebaseService
import ru.nickb.chatktln.ui.friends.FriendRequestFragment
import ru.nickb.chatktln.ui.friends.FriendsFragment
import ru.nickb.chatktln.ui.home.ChatsFragment
import ru.nickb.chatktln.ui.home.HomeActivity
import ru.nickb.chatktln.ui.login.LoginFragment
import javax.inject.Singleton

class App : Application() {

    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }

}

@Singleton
@Component(modules = [AppModule::class, CacheModule::class, RemoteModule::class, ViewModelModule::class])
interface  AppComponent {
    //activities
    fun inject(activity: RegisterActivity)
    fun inject(activity: HomeActivity)
    fun inject(activity: RouteActivity)
    /*fun inject(activity: AccountEntity)*/
    fun inject(activity: AccountActivity)

    //fragments
    fun inject(fragment: RegisterFragment)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: ChatsFragment)
    fun inject(fragment: FriendsFragment)
    fun inject(fragment: FriendRequestFragment)
    fun inject(fragment: AccountFragment)

    //services
    fun inject(service: FirebaseService)
}
