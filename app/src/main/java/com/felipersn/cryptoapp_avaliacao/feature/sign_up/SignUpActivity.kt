package com.felipersn.cryptoapp_avaliacao.feature.sign_up

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.felipersn.cryptoapp_avaliacao.R

class SignUpActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, this::class.java)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }
}