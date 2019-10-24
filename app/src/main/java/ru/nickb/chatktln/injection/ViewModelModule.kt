package ru.nickb.chatktln.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.nickb.chatktln.presentation.viewmodel.AccountViewModel
import ru.nickb.chatktln.presentation.viewmodel.FriendsViewModel
import ru.nickb.chatktln.presentation.viewmodel.MediaViewModel
import ru.nickb.chatktln.presentation.viewmodel.ViewModelFactory

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AccountViewModel::class)
    abstract fun bindAccountViewModel(accountViewModel: AccountViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FriendsViewModel::class)
    abstract fun bindFriendsViewModel(friendsViewModel: FriendsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MediaViewModel::class)
    abstract fun bindMediaViewModel(mediaViewModel: MediaViewModel): ViewModel
}