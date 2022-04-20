package com.felipersn.cryptoapp_avaliacao.common.extensions

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.felipersn.cryptoapp_avaliacao.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder


fun Context.provideSignOutDialog(onPositiveClick: () -> Unit): AlertDialog {
    val builder = MaterialAlertDialogBuilder(this)
    builder.apply {
        setTitle(R.string.home_signOutDialog_title)
        setMessage(R.string.home_signOutDialog_message)
        setPositiveButton(R.string.home_signOutDialog_positive) { dialog, _ ->
            dialog.dismiss()
            onPositiveClick.invoke()
        }
        setNegativeButton(R.string.home_signOutDialog_negative) { dialog, _ ->
            dialog.dismiss()
        }
    }
    return builder.create()
}