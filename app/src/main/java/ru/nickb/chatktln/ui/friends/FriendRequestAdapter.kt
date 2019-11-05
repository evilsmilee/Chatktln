package ru.nickb.chatktln.ui.friends

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_friend_request.view.*
import ru.nickb.chatktln.R
import ru.nickb.chatktln.databinding.ItemFriendBinding
import ru.nickb.chatktln.databinding.ItemFriendRequestBinding
import ru.nickb.chatktln.domain.friends.FriendEntity
import ru.nickb.chatktln.ui.core.BaseAdapter
import ru.nickb.chatktln.ui.core.GlideHelper

open class FriendRequestAdapter: BaseAdapter<FriendRequestAdapter.FriendRequestViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendRequestViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFriendRequestBinding.inflate(layoutInflater)
        return FriendRequestViewHolder(binding)
    }

    class FriendRequestViewHolder(val binding: ItemFriendRequestBinding): BaseViewHolder(binding.root) {

        init {
            binding.btnApprove.setOnClickListener {
                onClick?.onClick(item, it)
            }
            binding.btnCancel.setOnClickListener {
                onClick?.onClick(item, it)
            }
        }

        override fun onBind(item: Any) {

            (item as? FriendEntity)?.let {
                binding.friend = it
                /*GlideHelper.loadImage(view.context, it.image, view.imgPhoto, R.drawable.ic_account_circle)
                view.tvName.text = it.name*/
            }
        }
    }
}