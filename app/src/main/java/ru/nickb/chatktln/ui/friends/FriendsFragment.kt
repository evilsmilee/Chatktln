package ru.nickb.chatktln.ui.friends

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import ru.nickb.chatktln.R
import ru.nickb.chatktln.domain.friends.FriendEntity
import ru.nickb.chatktln.domain.type.None
import ru.nickb.chatktln.presentation.viewmodel.FriendsViewModel
import ru.nickb.chatktln.ui.App
import ru.nickb.chatktln.ui.core.BaseListFragment
import ru.nickb.chatktln.ui.core.ext.onFailure
import ru.nickb.chatktln.ui.core.ext.onSuccess

class FriendsFragment: BaseListFragment() {
    override val viewAdapter = FriendsAdapter()

    lateinit var friendsViewModel: FriendsViewModel

    override val titleToolbar: Int = R.string.screen_friends

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        friendsViewModel = viewModel {
            onSuccess(friendsData, ::handleFriends)
            onSuccess(deleteFriendData, ::handleDeleteFriend)
            onSuccess(progressData, ::updateProgress)
            onFailure(failureData, ::handleFailure)
        }

        setOnItemClickListener{it, v ->
            (it as? FriendEntity)?.let {
                when(v.id) {
                    R.id.btnRemove -> showDeleteFriendDialog(it)
                    else -> {
                        navigator.showUser(requireActivity(), it)
                    }
                }
            }
        }

        friendsViewModel.getFriends()
    }

/*    override fun onResume() {
        super.onResume()
        showProgress()

    }*/

    private fun showDeleteFriendDialog(entity: FriendEntity) {
        activity?.let {
            AlertDialog.Builder(it)
                .setMessage(getString(R.string.delete_friend))

                .setPositiveButton(android.R.string.yes) { dialog, which ->
                    friendsViewModel.deleteFriend(entity)
                }

                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show()
        }
    }

    private fun handleFriends(friends: List<FriendEntity>?) {
        hideProgress()
        if (friends != null) {
            viewAdapter.submitList(friends)
        }
    }

    private fun handleDeleteFriend(none: None?) {
        friendsViewModel.getFriends()
    }
}