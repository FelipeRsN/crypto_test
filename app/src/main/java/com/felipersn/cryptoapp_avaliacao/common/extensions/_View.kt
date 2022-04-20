package com.felipersn.cryptoapp_avaliacao.common.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.felipersn.cryptoapp_avaliacao.common.utils.DISABLED_VIEW_ALPHA
import com.felipersn.cryptoapp_avaliacao.common.utils.ENABLED_VIEW_ALPHA

/* Used to toggle view click and alpha if this view is enabled or disabled */
fun View?.toggleEnabled(isEnabled: Boolean) {
    this?.let {
        it.isEnabled = isEnabled
        it.isClickable = isEnabled
        if (isEnabled) it.enable() else it.disable()
    }
}

/* Used to enable a view using constant alpha value  */
fun View?.enable() {
    this?.let { it.alpha = ENABLED_VIEW_ALPHA }
}

/* Used to disable a view using constant alpha value  */
fun View?.disable() {
    this?.let { it.alpha = DISABLED_VIEW_ALPHA }
}

/* used to inflate an layout inside an adapter */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}