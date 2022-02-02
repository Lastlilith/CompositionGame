@file:Suppress("DEPRECATION")

package com.example.compositiongame.utils

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.fragment.app.Fragment

fun Fragment.doubleVibrateButton() {
    val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (Build.VERSION.SDK_INT >= 26) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            vibrator.vibrate( VibrationEffect.createOneShot(200, VibrationEffect.EFFECT_DOUBLE_CLICK))
        }
    } else {
        vibrator.vibrate(200)
    }
}

fun Fragment.vibrateButton() {
    val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (Build.VERSION.SDK_INT >= 26) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.EFFECT_TICK))
        }
    } else {
        vibrator.vibrate(200)
    }
}