package ru.nickb.chatktln.domain.media

import android.graphics.Bitmap
import ru.nickb.chatktln.domain.interactor.UseCase
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure
import javax.inject.Inject

class EncodeImageBitmap @Inject constructor(private val mediaRepository: MediaRepository): UseCase<String, Bitmap>() {

    override suspend fun run(params: Bitmap): Either<Failure, String> = mediaRepository.encodeImageBitmap(params)

}