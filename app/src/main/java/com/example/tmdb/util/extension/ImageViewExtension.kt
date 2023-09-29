package com.example.tmdb.util.extension

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

fun ImageView.loadFromUrl(url: String?, @DrawableRes placeholder: Int? = null) {
    if (url.isNullOrEmpty()) return

    Glide.with(this)
        .load(url)
        .apply {
            placeholder?.let {
                placeholder(it)
                error(it)
            }
        }
        .into(this)
}