package ru.nickb.chatktln.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_forget_password.*
import ru.nickb.chatktln.R
import ru.nickb.chatktln.domain.type.None
import ru.nickb.chatktln.presentation.viewmodel.AccountViewModel
import ru.nickb.chatktln.ui.App
import ru.nickb.chatktln.ui.core.BaseFragment
import ru.nickb.chatktln.ui.core.ext.onFailure
import ru.nickb.chatktln.ui.core.ext.onSuccess

class ForgetPasswordFragment : BaseFragment() {
    override val layoutId: Int = R.layout.fragment_forget_password
    override val titleToolbar: Int = R.string.screen_forget_password

    lateinit var accountViewModel: AccountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accountViewModel = viewModel {
            onSuccess(forgetPasswordData, ::onPasswordSent)
            onFailure(failureData, ::handleFailure)
        }

        btnSendPassword.setOnClickListener {
            sendPassword()
        }
    }

    private fun sendPassword() {
        if (etEmail.testValidity()) {
            val email = etEmail.text.toString()
            accountViewModel.forgetPassword(email)
        }
    }

    private fun onPasswordSent(none: None?) {
        Toast.makeText(requireContext(), getString(R.string.email_sent), Toast.LENGTH_SHORT).show()
        activity?.finish()
    }
}