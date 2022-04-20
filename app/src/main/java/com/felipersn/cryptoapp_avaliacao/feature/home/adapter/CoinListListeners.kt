package com.felipersn.cryptoapp_avaliacao.feature.home.adapter

import com.felipersn.cryptoapp_avaliacao.data.entity.Coin

interface CoinListListeners {
    fun onItemClicked(coin: Coin)
    fun onFavoriteChanged(coinName: String, newFavoriteStatus: Boolean)
}