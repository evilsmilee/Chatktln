package ru.nickb.chatktln.ui.account

import android.os.Bundle
import ru.nickb.chatktln.ui.App
import ru.nickb.chatktln.ui.core.BaseActivity
import ru.nickb.chatktln.ui.core.BaseFragment

class AccountActivity: BaseActivity() {

    override var fragment: BaseFragment = AccountFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }
}