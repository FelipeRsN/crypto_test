package com.felipersn.cryptoapp_avaliacao.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    val id: String? = null,
    val name: String? = null,
    val position: String? = null
): Parcelable