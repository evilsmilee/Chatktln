package ru.nickb.chatktln.domain.media

import android.graphics.Bitmap
import android.net.Uri
import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import javax.inject.Inject

class GetPickedImage @Inject constructor(private val mediaRepository: MediaRepository): UseCase<Bitmap, Uri?>() {

    override suspend fun run(params: Uri?): Either<Failure, Bitmap> = mediaRepository.getPickedImage(params)

}