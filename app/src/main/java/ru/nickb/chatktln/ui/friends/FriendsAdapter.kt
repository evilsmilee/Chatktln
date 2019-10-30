package ru.nickb.chatktln.ui.friends

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_friend.view.*
import ru.nickb.chatktln.R
import ru.nickb.chatktln.databinding.ItemFriendBinding
import ru.nickb.chatktln.domain.friends.FriendEntity
import ru.nickb.chatktln.ui.core.BaseAdapter
import ru.nickb.chatktln.ui.core.GlideHelper

open class FriendsAdapter: BaseAdapter<FriendsAdapter.FriendsViewHolder>() {
    override val layoutRes = R.layout.item_friend

    override fun createHolder(parent: ViewGroup): FriendsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFriendBinding.inflate(layoutInflater, parent, false)
        return FriendsViewHolder(binding)
    }

    class FriendsViewHolder(val binding: ItemFriendBinding) : BaseViewHolder(binding.root) {

        init {
            binding.btnRemove.setOnClickListener {
                onClick?.onClick(item, it)
            }
        }

        override fun onBind(item: Any) {
            (item as? FriendEntity)?.let {
                binding.friend = it
                /*GlideHelper.loadImage(view.context, it?.image, view.imgPhoto, R.drawable.ic_account_circle)
                view.tvName.text = it?.name
                view.tvStatus.text = it?.status

                view.tvStatus.visibility = if (it?.status!!.isNotEmpty()) View.VISIBLE else View.GONE*/
            }
        }
    }
}