package com.felipersn.cryptoapp_avaliacao.feature.sign_in

import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.felipersn.cryptoapp_avaliacao.common.base.BaseAppCompatActivity
import com.felipersn.cryptoapp_avaliacao.common.extensions.toggleEnabled
import com.felipersn.cryptoapp_avaliacao.databinding.ActivitySignInBinding
import com.felipersn.cryptoapp_avaliacao.feature.home.HomeActivity
import com.felipersn.cryptoapp_avaliacao.feature.sign_up.SignUpActivity

class SignInActivity : BaseAppCompatActivity() {

    private val signInBinding by lazy { ActivitySignInBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(signInBinding.root)
    }

    override fun initView() {
        super.initView()

        // Ensure that login button starts disabled to force
        // user to fill the fields before click
        //checkFieldsAndToggleButton()
    }

    override fun setupListeners() {
        super.setupListeners()
        signInBinding.signInEnter.setOnClickListener {
            openHomeActivity()
        }

        signInBinding.signInSignUp.setOnClickListener {
            openSignUpActivity()
        }

        signInBinding.signInLogin.editText?.addTextChangedListener {
            checkFieldsAndToggleButton()
        }

        signInBinding.signInPassword.editText?.addTextChangedListener {
            checkFieldsAndToggleButton()
        }
    }

    private fun checkFieldsAndToggleButton() {
        val loginEmpty = signInBinding.signInLogin.editText?.text.isNullOrEmpty()
        val passwordEmpty = signInBinding.signInPassword.editText?.text.isNullOrEmpty()

        signInBinding.signInEnter.toggleEnabled(isEnabled = !loginEmpty && !passwordEmpty)
    }

    private fun openHomeActivity() {
        startActivity(
            HomeActivity.getIntent(this)
        )
    }

    private fun openSignUpActivity() {
        startActivity(
            SignUpActivity.getIntent(this)
        )
    }
}