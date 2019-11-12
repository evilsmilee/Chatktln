package ru.nickb.chatktln.ui.home

import android.os.Bundle
import ru.nickb.chatktln.ui.App
import ru.nickb.chatktln.ui.core.BaseActivity
import ru.nickb.chatktln.ui.core.BaseFragment

class MessagesActivity : BaseActivity() {
    override var fragment: BaseFragment = MessagesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }
}