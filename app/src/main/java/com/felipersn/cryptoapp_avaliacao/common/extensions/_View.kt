package com.felipersn.cryptoapp_avaliacao.common.extensions

import android.view.View
import com.felipersn.cryptoapp_avaliacao.common.utils.DISABLED_VIEW_ALPHA
import com.felipersn.cryptoapp_avaliacao.common.utils.ENABLED_VIEW_ALPHA

fun View?.toggleEnabled(isEnabled: Boolean) {
    this?.let {
        it.isEnabled = isEnabled
        it.isClickable = isEnabled
        if (isEnabled) it.enable() else it.disable()
    }
}

fun View?.enable() {
    this?.let { it.alpha = ENABLED_VIEW_ALPHA }
}

fun View?.disable() {
    this?.let { it.alpha = DISABLED_VIEW_ALPHA }
}