package com.felipersn.cryptoapp_avaliacao.feature.detail.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.felipersn.cryptoapp_avaliacao.R
import com.felipersn.cryptoapp_avaliacao.common.extensions.inflate
import com.felipersn.cryptoapp_avaliacao.data.entity.Tag

class TagListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var adapterList: ArrayList<Tag?> = ArrayList()

    override fun getItemCount(): Int {
        return adapterList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = parent.inflate(R.layout.list_item_tag)
        return TagListViewHolder(view)
    }

    fun populateAdapter(itemsList: List<Tag?>) {
        adapterList.clear()
        adapterList = ArrayList(itemsList)
        notifyItemRangeInserted(0, itemsList.size)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as TagListViewHolder
        val entity = adapterList[position]

        entity?.let { bindItemViewHolder(itemViewHolder, entity) }
    }

    @SuppressLint("SetTextI18n")
    private fun bindItemViewHolder(
        viewHolder: TagListViewHolder,
        item: Tag,
    ) {
        viewHolder.root.text = item.name
    }
}