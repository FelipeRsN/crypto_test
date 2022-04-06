package com.felipersn.cryptoapp_avaliacao.common.extensions

import android.view.View

fun View?.toggleEnabled(isEnabled: Boolean) {
    this?.let {
        it.isEnabled = isEnabled
        it.isClickable = isEnabled
        it.alpha = if (isEnabled) 1f else 0.5f
    }
}