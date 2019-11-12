package ru.nickb.chatktln.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import ru.nickb.chatktln.R
import ru.nickb.chatktln.cache.ChatDatabase
import ru.nickb.chatktln.domain.messages.MessageEntity
import ru.nickb.chatktln.presentation.viewmodel.MessagesViewModel
import ru.nickb.chatktln.ui.App
import ru.nickb.chatktln.ui.core.BaseAdapter
import ru.nickb.chatktln.ui.core.BaseFragment
import ru.nickb.chatktln.ui.core.BaseListFragment
import ru.nickb.chatktln.ui.core.ext.onFailure
import ru.nickb.chatktln.ui.core.ext.onSuccess

class ChatsFragment: BaseListFragment() {

    override val viewAdapter = ChatsAdapter()

    override val titleToolbar = R.string.chats

    private lateinit var messagesViewModel: MessagesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        messagesViewModel = viewModel {
            onSuccess(progressData, ::updateProgress)
            onFailure(failureData, ::handleFailure)
        }

        viewAdapter.setOnClick( {it, v ->
            (it as? MessageEntity)?.let {
                val contact = it.contact
                if (contact != null) {
                    navigator.showChatWithContact(contact.id, contact.name, requireActivity())
                }
            }
        })

        ChatDatabase.getInstance(requireContext()).messagesDao.getLiveChats().observe(this, Observer {
            val list = it.distinctBy { it.contact?.id }.toList()
            handleChats(list)
        })
    }

    override fun onResume() {
        super.onResume()

        messagesViewModel.getChats()
    }

    fun handleChats(messages: List<MessageEntity>?) {
        if (messages != null && messages.isNotEmpty()) {
            viewAdapter.submitList(messages)
        }
    }
}