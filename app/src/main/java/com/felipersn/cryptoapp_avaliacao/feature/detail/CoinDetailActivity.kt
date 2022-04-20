package com.felipersn.cryptoapp_avaliacao.feature.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.felipersn.cryptoapp_avaliacao.R
import com.felipersn.cryptoapp_avaliacao.common.base.BaseAppCompatActivity
import com.felipersn.cryptoapp_avaliacao.common.extensions.toast
import com.felipersn.cryptoapp_avaliacao.common.utils.IntentValues
import com.felipersn.cryptoapp_avaliacao.data.entity.Coin
import com.felipersn.cryptoapp_avaliacao.databinding.ActivityCoinDetailBinding
import com.felipersn.cryptoapp_avaliacao.feature.detail.adapter.TagListAdapter
import com.felipersn.cryptoapp_avaliacao.feature.detail.adapter.TeamListAdapter

class CoinDetailActivity : BaseAppCompatActivity() {

    companion object {
        fun getIntent(context: Context, coin: Coin): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(IntentValues.COIN_DATA.get, coin)
            return intent
        }
    }

    private val coinDetailBinding by lazy { ActivityCoinDetailBinding.inflate(layoutInflater) }

    private lateinit var coin: Coin


    private val tagListAdapter by lazy { TagListAdapter() }
    private val teamListAdapter by lazy { TeamListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(coinDetailBinding.root)
    }

    override fun setupIntentExtras() {
        super.setupIntentExtras()
        coin = intent.getParcelableExtra(IntentValues.COIN_DATA.get) ?: Coin()
    }

    override fun setupScreen() {
        super.setupScreen()

        if (coin.id != null) {
            setSupportActionBar(coinDetailBinding.coinDetailToolbar)
            supportActionBar?.title = "(${coin.symbol}) ${coin.name}"

            coinDetailBinding.coiDetailDescription.text = coin.description ?: "--"

            /* Set adapter to recyclerView and populate mocked lists */
            setupRecyclerView()
        } else {
            toast(getString(R.string.detail_invalidCoin))
        }
    }

    private fun setupRecyclerView() {
        if (!coin.tags.isNullOrEmpty()) {
            coinDetailBinding.coinDetailTagList.adapter = tagListAdapter
            tagListAdapter.populateAdapter(coin.tags!!)
        }

        if (!coin.team.isNullOrEmpty()) {
            coinDetailBinding.coinDetailTeamList.adapter = teamListAdapter
            teamListAdapter.populateAdapter(coin.team!!)
        }
    }
}