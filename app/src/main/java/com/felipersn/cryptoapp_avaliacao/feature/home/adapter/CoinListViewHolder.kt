package com.felipersn.cryptoapp_avaliacao.feature.home.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.felipersn.cryptoapp_avaliacao.R

class CoinListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val root by lazy { itemView.findViewById<CardView>(R.id.listItemCoin_root) }
    val ranking by lazy { itemView.findViewById<TextView>(R.id.listItemCoin_ranking) }
    val name by lazy { itemView.findViewById<TextView>(R.id.listItemCoin_name) }
    val favoriteIcon by lazy { itemView.findViewById<ImageView>(R.id.listItemCoin_favoriteIcon) }
}