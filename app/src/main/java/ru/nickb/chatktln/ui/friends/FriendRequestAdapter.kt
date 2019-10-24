package ru.nickb.chatktln.ui.friends

import android.view.View
import kotlinx.android.synthetic.main.item_friend_request.view.*
import ru.nickb.chatktln.R
import ru.nickb.chatktln.domain.friends.FriendEntity
import ru.nickb.chatktln.ui.core.BaseAdapter

open class FriendRequestAdapter: BaseAdapter<FriendRequestAdapter.FriendRequestViewHolder>() {
    override val layoutRes: Int = R.layout.item_friend_request

    override fun createHolder(
        view: View,
        viewType: Int
    ): FriendRequestAdapter.FriendRequestViewHolder {
        return FriendRequestViewHolder(view)
    }

    class FriendRequestViewHolder(view: View): BaseViewHolder(view) {

        init {
            view.btnApprove.setOnClickListener {
                onClick?.onClick(item, it)
            }
            view.btnCancel.setOnClickListener {
                onClick?.onClick(item, it)
            }
        }

        override fun onBind(item: Any) {

            (item as? FriendEntity)?.let {
                view.tvName.text = it.name
            }
        }
    }
}