package com.mertyigit0.timecapsule.util

import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageUtil {
    fun loadImage(imageView: ImageView, imageUrl: String?) {
        if (imageUrl != null) {
            Glide.with(imageView.context)
                .load(imageUrl)
                .placeholder(android.R.drawable.ic_menu_report_image) // Opsiyonel: Placeholder resmi
                .error(android.R.drawable.ic_menu_report_image) // Opsiyonel: Hata resmi
                .into(imageView)
        }
    }
}
