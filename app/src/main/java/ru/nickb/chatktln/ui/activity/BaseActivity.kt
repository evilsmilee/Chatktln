package ru.nickb.chatktln.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.OneShotPreDrawListener.add
import androidx.lifecycle.ViewModelProvider
import ru.nickb.chatktln.R
import ru.nickb.chatktln.domain.type.Exception.Failure
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity() {

    abstract val fragment: BaseFragment

    @Inject
    lateinit var  viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        setSupportActionBar(tolbar)
        addFragment(savedInstanceState)
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(
            R.id.fragmentContainer
        ) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    fun addFragment(savedInstanceState: Bundle?) {
        savedInstanceState ?: supportFragmentManager.inTransaction {
            add(R.id.fragmentContainer, fragment)
        }
    }

    fun showProgress() = progressStatus(View.VISIBLE)

    fun hideProgress() = progressStatus(View.GONE)

    fun progressStatus(viewStatus: Int) {
        toolbar_progress_bar.visibility = viewStatus
    }

    fun handleFailure(failure: Failure?) {
        hideProgress()
        when(failure) {
            is Failure.NetworkConnectionError -> showMessage(getString(R.string.error_network))
        }
    }
}