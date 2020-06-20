package com.denisbeck.instagrammainpage.animation

import android.animation.ObjectAnimator
import android.view.View
import com.denisbeck.instagrammainpage.extensions.dpToPx

fun View.translateY(dp: Int) {
    val distance = context.dpToPx(dp).toFloat()
    visibility = View.VISIBLE
    ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, distance).start()
}