package ru.nickb.chatktln.ui

import android.app.Application
import dagger.Component
import ru.nickb.chatktln.injection.AppModule
import ru.nickb.chatktln.injection.CacheModule
import ru.nickb.chatktln.injection.RemoteModule
import ru.nickb.chatktln.injection.ViewModelModule
import ru.nickb.chatktln.ui.activity.RegisterActivity
import ru.nickb.chatktln.ui.fragment.RegisterFragment
import ru.nickb.chatktln.ui.service.FirebaseService
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

    //fragments
    fun inject(fragment: RegisterFragment)

    //services
    fun inject(service: FirebaseService)
}
