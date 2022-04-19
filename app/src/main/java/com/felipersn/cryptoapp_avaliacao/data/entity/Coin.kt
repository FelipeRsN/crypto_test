package com.felipersn.cryptoapp_avaliacao.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coin(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val rank: Int? = null,
    val symbol: String? = null,
    val tags: List<Tag>? = null,
    val team: List<Team>? = null
) : Parcelable