package ru.nickb.chatktln.ui.user

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.android.synthetic.main.item_friend.*
import kotlinx.android.synthetic.main.item_friend.imgPhoto
import kotlinx.android.synthetic.main.item_friend.tvName
import kotlinx.android.synthetic.main.item_friend.tvStatus
import ru.nickb.chatktln.R
import ru.nickb.chatktln.remote.service.ApiService
import ru.nickb.chatktln.ui.core.BaseFragment
import ru.nickb.chatktln.ui.core.GlideHelper

class UserFragment: BaseFragment() {
    override val layoutId: Int = R.layout.fragment_user

    override val titleToolbar: Int = R.string.screen_user

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        base {
            val args = intent.getBundleExtra("args")
            if(args != null) {
                val image = args.getString(ApiService.PARAM_IMAGE)
                val name = args.getString(ApiService.PARAM_NAME)
                val email = args.getString(ApiService.PARAM_EMAIL)
                val status = args.getString(ApiService.PARAM_STATUS)

                GlideHelper.loadImage(requireContext(), image, imgPhoto, R.drawable.ic_account_circle)

                tvName.text = name
                tvEmail.text = email
                tvStatus.text = status

                if (tvStatus.text.isEmpty()) {
                    tvStatus.visibility = View.GONE
                    tvHintStatus.visibility = View.GONE
                }
            }
        }
    }
}