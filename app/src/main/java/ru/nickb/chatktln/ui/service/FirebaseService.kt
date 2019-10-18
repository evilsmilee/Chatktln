package ru.nickb.chatktln.ui.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import ru.nickb.chatktln.domain.account.UpdateToken
import ru.nickb.chatktln.ui.App
import javax.inject.Inject

class FirebaseService: FirebaseMessagingService() {

    @Inject
    lateinit var updateToken: UpdateToken

    override fun onCreate() {
        super.onCreate()
        App.appComponent.inject(this)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {

    }

    override fun onNewToken(token: String?) {
        Log.e("fv token", ": $token")
        if (token != null) {
            updateToken(UpdateToken.Params(token))
        }
    }
}