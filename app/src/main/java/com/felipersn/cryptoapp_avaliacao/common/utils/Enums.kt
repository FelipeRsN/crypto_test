package com.felipersn.cryptoapp_avaliacao.common.utils

/* Used to select which coin need to be shown on list, all coins from API or just favorites */
enum class CoinVisualization {
    ALL, FAVORITE_ONLY
}

/* Used to send data between activities */
enum class IntentValues(val get: String) {
    COIN_DATA("COIN_DATA")
}