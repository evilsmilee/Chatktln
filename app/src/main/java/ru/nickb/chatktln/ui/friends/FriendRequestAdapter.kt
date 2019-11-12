package ru.nickb.chatktln.ui.friends

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.nickb.chatktln.databinding.ItemFriendRequestBinding
import ru.nickb.chatktln.domain.friends.FriendEntity
import ru.nickb.chatktln.ui.core.BaseAdapter

open class FriendRequestAdapter:
    BaseAdapter<FriendEntity, FriendRequestAdapter.FriendRequestViewHolder>(FriendsAdapter.FriendsDiffCallback()) {


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
            }
        }
    }
}