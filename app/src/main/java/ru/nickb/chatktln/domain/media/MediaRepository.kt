package ru.nickb.chatktln.domain.media

import android.graphics.Bitmap
import android.net.Uri
import ru.nickb.chatktln.domain.type.Either
import ru.nickb.chatktln.domain.type.Failure

interface MediaRepository {
    fun createImageFile(): Either<Failure, Uri>
    fun encodeImageBitmap(bitmap: Bitmap?): Either<Failure, String>
    fun getPickedImage(uri: Uri?): Either<Failure, Bitmap>
}