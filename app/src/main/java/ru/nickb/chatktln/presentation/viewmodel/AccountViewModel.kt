package ru.nickb.chatktln.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import ru.nickb.chatktln.domain.account.Register
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

class AccountViewModel @Inject constructor(val registerUseCase: Register): BaseViewModel() {

    var registerData: MutableLiveData<None> = MutableLiveData()

    fun register(email: String, name: String, password: String) {
        registerUseCase(Register.Params(email, name, password)) {
            it.either(::handleFailure, ::handleRegister)
        }
    }

    private fun handleRegister(none: None) {
        this.registerData.value = none
    }

    override fun onCleared() {
        super.onCleared()
        registerUseCase.unsubscribe()
    }
}