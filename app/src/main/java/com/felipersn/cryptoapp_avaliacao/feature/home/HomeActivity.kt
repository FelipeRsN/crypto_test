package com.felipersn.cryptoapp_avaliacao.feature.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.felipersn.cryptoapp_avaliacao.common.base.BaseAppCompatActivity
import com.felipersn.cryptoapp_avaliacao.databinding.ActivityHomeBinding

class HomeActivity : BaseAppCompatActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    private val homeBinding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(homeBinding.root)
    }

    override fun setupScreen() {
        super.setupScreen()
    }

}