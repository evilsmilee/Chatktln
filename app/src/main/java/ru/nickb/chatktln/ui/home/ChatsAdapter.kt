package ru.nickb.chatktln.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.nickb.chatktln.databinding.ItemChatBinding
import ru.nickb.chatktln.domain.messages.MessageEntity
import ru.nickb.chatktln.ui.core.BaseAdapter


open class ChatsAdapter : MessagesAdapter() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemChatBinding.inflate(layoutInflater, parent, false)
        return ChatViewHolder(binding)
    }

    class ChatViewHolder(val binding: ItemChatBinding): BaseViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onClick?.onClick(item, it)
            }
        }

        override fun onBind(item: Any) {
            (item as? MessageEntity)?.let {
                binding.message = it
            }
        }
    }
}