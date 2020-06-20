package com.denisbeck.instagrammainpage.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.View
import android.widget.ImageView
import com.denisbeck.instagrammainpage.R
import com.denisbeck.instagrammainpage.extensions.insertDrawable

fun ImageView.likeAnimation() {
    isClickable = false
    tuneAnimation(0f) {
        changeDrawable(R.drawable.ic_like, R.drawable.ic_like_fill)
        tuneAnimation(1.2f) {
            tuneAnimation(1f) {
                isClickable = true
            }
        }
    }
}

fun ImageView.repeatLikeAnimation() {
    isClickable = false
    tuneAnimation(1.2f) {
        tuneAnimation(1f) {
            isClickable = true
        }
    }
}

private fun ImageView.tuneAnimation(scale: Float, listenerEnd: () -> Unit) {
    getScaleObjectAnimator(scale, scale).apply {
        animatorEndListener { listenerEnd() }
        duration = 200
        start()
    }
}

private fun ImageView.getScaleObjectAnimator(x: Float, y: Float): ObjectAnimator {
    val scaleX1 = PropertyValuesHolder.ofFloat(View.SCALE_X, x)
    val scaleY1 = PropertyValuesHolder.ofFloat(View.SCALE_Y, y)
    return ObjectAnimator.ofPropertyValuesHolder(this, scaleX1, scaleY1)
}

private fun ObjectAnimator.animatorEndListener(listenerEnd: (() -> Unit)) {
    addListener(object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator?) {
            listenerEnd()
        }
    })
}

private fun ImageView.changeDrawable(borderDrawable: Int, fillDrawable: Int) {
    if (tag == context.getString(R.string.ic_tag_border)) {
        tag = context.getString(R.string.ic_tag_fill)
        insertDrawable(fillDrawable)
    } else {
        tag = context.getString(R.string.ic_tag_border)
        insertDrawable(borderDrawable)
    }
}
