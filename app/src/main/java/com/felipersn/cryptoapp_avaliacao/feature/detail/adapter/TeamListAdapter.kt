package com.felipersn.cryptoapp_avaliacao.feature.detail.adapter

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.felipersn.cryptoapp_avaliacao.R
import com.felipersn.cryptoapp_avaliacao.common.extensions.inflate
import com.felipersn.cryptoapp_avaliacao.data.entity.Team

class TeamListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var adapterList: ArrayList<Team?> = ArrayList()

    override fun getItemCount(): Int {
        return adapterList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = parent.inflate(R.layout.list_item_team)
        return TeamListViewHolder(view)
    }

    fun populateAdapter(itemsList: List<Team?>) {
        adapterList.clear()
        adapterList = ArrayList(itemsList)
        notifyItemRangeInserted(0, itemsList.size)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as TeamListViewHolder
        val entity = adapterList[position]

        entity?.let { bindItemViewHolder(itemViewHolder, entity, position) }
    }

    @SuppressLint("SetTextI18n")
    private fun bindItemViewHolder(
        viewHolder: TeamListViewHolder,
        item: Team,
        position: Int
    ) {
        viewHolder.name.text = item.name
        viewHolder.role.text = item.position

        val dividerVisibility = if (position == itemCount - 1) View.GONE
        else View.VISIBLE

        viewHolder.divider.visibility = dividerVisibility
    }
}