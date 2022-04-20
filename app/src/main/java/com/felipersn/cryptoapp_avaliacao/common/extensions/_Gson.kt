package com.felipersn.cryptoapp_avaliacao.common.extensions

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


inline fun <reified T> Gson.fromJsonArray(jsonArray: String): ArrayList<T> {
    val itemType = object : TypeToken<ArrayList<T>>() {}.type
    return fromJson(jsonArray, itemType)
}