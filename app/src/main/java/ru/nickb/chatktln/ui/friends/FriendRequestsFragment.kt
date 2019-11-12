package ru.nickb.chatktln.ui.friends

import android.os.Bundle
import android.view.View
import ru.nickb.chatktln.R
import ru.nickb.chatktln.domain.friends.FriendEntity
import ru.nickb.chatktln.domain.type.None
import ru.nickb.chatktln.presentation.viewmodel.FriendsViewModel
import ru.nickb.chatktln.ui.App
import ru.nickb.chatktln.ui.core.BaseAdapter
import ru.nickb.chatktln.ui.core.BaseListFragment
import ru.nickb.chatktln.ui.core.ext.onFailure
import ru.nickb.chatktln.ui.core.ext.onSuccess

class FriendRequestsFragment : BaseListFragment() {
    override val viewAdapter = FriendRequestAdapter()

    override val layoutId: Int = R.layout.inner_fragment_list

    lateinit var friendsViewModel: FriendsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        base {
            friendsViewModel = viewModel {
                onSuccess(friendRequestsData, ::handleFriendRequests)
                onSuccess(approveFriendData, ::handleFriendRequestAction)
                onSuccess(cancelFriendData, ::handleFriendRequestAction)
                onFailure(failureData, ::handleFailure)
            }
        }

        setOnItemClickListener{item, v ->
            (item as? FriendEntity)?.let {
                when(v.id) {
                    R.id.btnApprove -> {
                        showProgress()
                        friendsViewModel.approveFriend(it)
                    }
                    R.id.btnCancel -> {
                        showProgress()
                        friendsViewModel.cancelFriend(it)
                    }
                    else -> {
                        activity?.let { act ->
                            navigator.showUser(act, it)
                        }
                    }
                }
            }
        }

        friendsViewModel.getFriendRequests()
    }

   /* override fun onResume() {
        super.onResume()
        showProgress()

    }*/

    private fun handleFriendRequests(requests: List<FriendEntity>?) {
        hideProgress()
        if (requests != null) {
            viewAdapter.submitList(requests)
        }
    }

    private fun handleFriendRequestAction(none: None?) {
        hideProgress()
        friendsViewModel.getFriendRequests()
    }
}