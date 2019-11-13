package ru.nickb.chatktln.ui.user

import android.os.Bundle
import ru.nickb.chatktln.ui.App
import ru.nickb.chatktln.ui.core.BaseActivity
import ru.nickb.chatktln.ui.core.BaseFragment

class UserActivity: BaseActivity() {
    override var fragment: BaseFragment = UserFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }
}