package com.felipersn.cryptoapp_avaliacao.feature.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.felipersn.cryptoapp_avaliacao.R
import com.felipersn.cryptoapp_avaliacao.common.base.BaseAppCompatActivity
import com.felipersn.cryptoapp_avaliacao.common.extensions.*
import com.felipersn.cryptoapp_avaliacao.common.utils.CoinVisualization
import com.felipersn.cryptoapp_avaliacao.common.utils.JSON_COIN_LIST
import com.felipersn.cryptoapp_avaliacao.data.entity.Coin
import com.felipersn.cryptoapp_avaliacao.databinding.ActivityHomeBinding
import com.felipersn.cryptoapp_avaliacao.feature.detail.CoinDetailActivity
import com.felipersn.cryptoapp_avaliacao.feature.home.adapter.CoinListAdapter
import com.felipersn.cryptoapp_avaliacao.feature.home.adapter.CoinListListeners
import com.google.gson.Gson

class HomeActivity : BaseAppCompatActivity(), CoinListListeners {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    private val homeBinding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    private val coinJson by lazy { readJsonAsset(JSON_COIN_LIST) }
    private val coinList by lazy { Gson().fromJsonArray<Coin>(coinJson) }

    private val coinListAdapter by lazy { CoinListAdapter(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(homeBinding.root)
    }

    override fun setupScreen() {
        super.setupScreen()
        setSupportActionBar(homeBinding.homeToolbar)

        /* Start screen with selection to all coins */
        toggleButton(CoinVisualization.ALL)

        /* Set adapter to recyclerView and populate mocked list */
        setupRecyclerView()
    }

    override fun setupListeners() {
        super.setupListeners()

        homeBinding.homeShowAll.setOnClickListener {
            toggleButton(CoinVisualization.ALL)
        }

        homeBinding.homeShowOnlyFavorites.setOnClickListener {
            toggleButton(CoinVisualization.FAVORITE_ONLY)
        }
    }

    private fun setupRecyclerView() {
        homeBinding.homeCoinList.adapter = coinListAdapter
        coinListAdapter.populateAdapter(coinList)
    }

    private fun toggleButton(newVisualization: CoinVisualization) {
        when (newVisualization) {
            CoinVisualization.ALL -> {
                homeBinding.homeShowOnlyFavorites.disable()
                homeBinding.homeShowAll.enable()
            }
            CoinVisualization.FAVORITE_ONLY -> {
                homeBinding.homeShowOnlyFavorites.enable()
                homeBinding.homeShowAll.disable()
            }
        }
    }

    override fun onItemClicked(coin: Coin) {
        startActivity(CoinDetailActivity.getIntent(this, coin))
    }

    override fun onFavoriteChanged(coinName: String, newFavoriteStatus: Boolean) {
        val toastText = when (newFavoriteStatus) {
            true -> getString(R.string.home_action_onFavoriteAdded, coinName)
            else -> getString(R.string.home_action_onFavoriteRemoved, coinName)
        }

        toast(toastText)
    }

}