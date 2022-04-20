package com.felipersn.cryptoapp_avaliacao.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tag(
    val id: String? = null,
    val name: String? = null
) : Parcelable