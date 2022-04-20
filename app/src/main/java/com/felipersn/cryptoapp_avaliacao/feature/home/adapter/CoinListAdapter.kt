package com.felipersn.cryptoapp_avaliacao.feature.home.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.felipersn.cryptoapp_avaliacao.R
import com.felipersn.cryptoapp_avaliacao.common.extensions.inflate
import com.felipersn.cryptoapp_avaliacao.data.entity.Coin

class CoinListAdapter(private val coinListListeners: CoinListListeners) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var adapterList: ArrayList<Coin> = ArrayList()

    override fun getItemCount(): Int {
        return adapterList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = parent.inflate(R.layout.list_item_coin)
        return CoinListViewHolder(view)
    }

    fun populateAdapter(itemsList: ArrayList<Coin>) {
        adapterList.clear()
        adapterList = itemsList
        notifyItemRangeInserted(0, itemsList.size)
    }

    private fun updateItemFavoriteStatus(coinName: String, position: Int) {
        adapterList[position].apply {
            val favoriteToggled = !this.isFavorite

            this.isFavorite = favoriteToggled

            coinListListeners.onFavoriteChanged(coinName, favoriteToggled)
            notifyItemChanged(position)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as CoinListViewHolder
        val entity = adapterList[position]

        bindItemViewHolder(itemViewHolder, entity, position)
    }

    @SuppressLint("SetTextI18n")
    private fun bindItemViewHolder(
        viewHolder: CoinListViewHolder,
        item: Coin,
        position: Int,
    ) {
        viewHolder.ranking.text = "#${item.rank}"
        viewHolder.name.text = "(${item.symbol}) ${item.name}"

        val favoriteIcon = when (item.isFavorite) {
            true -> R.drawable.ic_favorite_filled_rounded_black
            false -> R.drawable.ic_favorite_rounded_outline_black
        }

        viewHolder.favoriteIcon.setImageResource(favoriteIcon)

        //listeners
        viewHolder.root.setOnClickListener {
            coinListListeners.onItemClicked(item)
        }

        viewHolder.favoriteIcon.setOnClickListener {
            updateItemFavoriteStatus(item.name ?: "--", position)
        }
    }
}