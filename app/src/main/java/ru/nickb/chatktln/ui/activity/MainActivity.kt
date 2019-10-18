package ru.nickb.chatktln.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import ru.nickb.chatktln.R
import ru.nickb.chatktln.cache.AccountCacheImpl
import ru.nickb.chatktln.cache.SharedPrefsManager
import ru.nickb.chatktln.data.Account.AccountRepositoryImpl
import ru.nickb.chatktln.domain.account.AccountRepository
import ru.nickb.chatktln.domain.account.Register
import ru.nickb.chatktln.remote.account.AccountRemoteImpl
import ru.nickb.chatktln.remote.core.NetworkHandler
import ru.nickb.chatktln.remote.core.Request
import ru.nickb.chatktln.remote.service.ServiceFactory

/*class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefs = this.getSharedPreferences(this.packageName, Context.MODE_PRIVATE)

        val accountCache = AccountCacheImpl(SharedPrefsManager(sharedPrefs))
        val accountRemote = AccountRemoteImpl(Request(NetworkHandler(this)), ServiceFactory.makeService(true))

        val accountRepository: AccountRepository = AccountRepositoryImpl(accountRemote, accountCache)

        val register = Register(accountRepository)
        register(Register.Params(email = "abbb@m.com", password =  "abbbcd", name = "123")) {
            it.either({
                Toast.makeText(this, it.javaClass.simpleName, Toast.LENGTH_SHORT).show()
            }, {
                Toast.makeText(this, "Аккаунт Создан", Toast.LENGTH_SHORT).show()
            })
        }
    }
}*/
