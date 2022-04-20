package com.felipersn.cryptoapp_avaliacao.feature.detail.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.felipersn.cryptoapp_avaliacao.R
import com.google.android.material.divider.MaterialDivider

class TeamListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name by lazy { itemView.findViewById<TextView>(R.id.teamItem_name) }
    val role by lazy { itemView.findViewById<TextView>(R.id.teamItem_role) }
    val divider by lazy { itemView.findViewById<MaterialDivider>(R.id.teamItem_divider) }
}