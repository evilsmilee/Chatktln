package ru.nickb.chatktln.ui.core

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import ru.nickb.chatktln.remote.service.ServiceFactory

object GlideHelper {

    //Сервер отдает неполную ссылку на изображение(без доменного имени). GlideHelper преобразовывает ее в полную, добавляя доменное имя.
    fun loadImage (context: Context, path: String?, iv: ImageView, placeholder: Drawable = iv.drawable) {
        val imgPath = ServiceFactory.SERVER_URL + path?.replace("..", "")

        Glide.with(context)
            .load(imgPath)
            .placeholder(placeholder)
            .error(placeholder)
            .into(iv)

    }

    fun loadImage(context: Context, path: String?, iv: ImageView, placeholder: Int) {
        loadImage(context, path, iv, context.resources.getDrawable(placeholder))
    }
}