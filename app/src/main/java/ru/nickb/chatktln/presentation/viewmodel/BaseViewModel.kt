package ru.nickb.chatktln.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nickb.chatktln.domain.type.Failure
import ru.nickb.chatktln.domain.type.HandleOnce

abstract class BaseViewModel: ViewModel() {

    val failureData: MutableLiveData<HandleOnce<Failure>> = MutableLiveData()
    val progressData: MutableLiveData<Boolean> = MutableLiveData()


    protected fun handleFailure(failure: Failure) {
        this.failureData.value = HandleOnce(failure)
    }

    protected fun updateProgress(process: Boolean) {
        this.progressData.value = process
    }
}