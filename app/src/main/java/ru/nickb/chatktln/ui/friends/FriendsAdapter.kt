package ru.nickb.chatktln.ui.friends

import android.view.View
import kotlinx.android.synthetic.main.item_friend.view.*
import ru.nickb.chatktln.R
import ru.nickb.chatktln.domain.friends.FriendEntity
import ru.nickb.chatktln.ui.core.BaseAdapter
import ru.nickb.chatktln.ui.core.GlideHelper

open class FriendsAdapter: BaseAdapter<FriendsAdapter.FriendsViewHolder>() {
    override val layoutRes = R.layout.item_friend

    override fun createHolder(view: View, viewType: Int): FriendsViewHolder {
        return FriendsViewHolder(view)
    }

    class FriendsViewHolder(view: View): BaseViewHolder(view) {

        init {
            view.btnRemove.setOnClickListener {
                onClick?.onClick(item, it)
            }
        }

        override fun onBind(item: Any) {
            (item as? FriendEntity?).let {
                GlideHelper.loadImage(view.context, it?.image, view.imgPhoto, R.drawable.ic_account_circle)
                view.tvName.text = it?.name
                view.tvStatus.text = it?.status

                view.tvStatus.visibility = if (it?.status!!.isNotEmpty()) View.VISIBLE else View.GONE
            }
        }
    }
}