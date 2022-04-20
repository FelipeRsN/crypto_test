package com.felipersn.cryptoapp_avaliacao.feature.detail.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.felipersn.cryptoapp_avaliacao.R
import com.google.android.material.chip.Chip

class TagListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val root by lazy { itemView.findViewById<Chip>(R.id.tagItem_root) }
}