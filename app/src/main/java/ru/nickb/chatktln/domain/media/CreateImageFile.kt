package ru.nickb.chatktln.domain.media

import android.net.Uri
import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.None
import javax.inject.Inject

class CreateImageFile @Inject constructor(private val mediaRepository: MediaRepository): UseCase<Uri, None>() {

    override suspend fun run(params: None) = mediaRepository.createImageFile()
}