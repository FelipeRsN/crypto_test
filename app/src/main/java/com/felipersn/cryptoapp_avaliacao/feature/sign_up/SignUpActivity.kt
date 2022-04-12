package com.felipersn.cryptoapp_avaliacao.feature.sign_up

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.felipersn.cryptoapp_avaliacao.R
import com.felipersn.cryptoapp_avaliacao.common.base.BaseAppCompatActivity
import com.felipersn.cryptoapp_avaliacao.common.extensions.toast
import com.felipersn.cryptoapp_avaliacao.common.extensions.toggleEnabled
import com.felipersn.cryptoapp_avaliacao.databinding.ActivitySignUpBinding

class SignUpActivity : BaseAppCompatActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, SignUpActivity::class.java)
        }
    }

    private val signUpBinding by lazy { ActivitySignUpBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(signUpBinding.root)
    }

    override fun initView() {
        super.initView()
        // Ensure that create account button starts disabled to force
        // user to fill the fields before click
        checkFieldsAndToggleButton()
    }

    override fun setupScreen() {
        super.setupScreen()
        setSupportActionBar(signUpBinding.signUpToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun setupListeners() {
        super.setupListeners()

        signUpBinding.signUpLogin.editText?.addTextChangedListener {
            checkFieldsAndToggleButton()
        }

        signUpBinding.signUpDocument.editText?.addTextChangedListener {
            checkFieldsAndToggleButton()
        }

        signUpBinding.signUpPassword.editText?.addTextChangedListener {
            checkFieldsAndToggleButton()
        }

        signUpBinding.signUpRetypePassword.editText?.addTextChangedListener {
            checkFieldsAndToggleButton()
        }

        signUpBinding.signUpCreate.setOnClickListener {
            createAccount()
        }
    }

    private fun checkFieldsAndToggleButton() {
        val loginEmpty = signUpBinding.signUpLogin.editText?.text.isNullOrEmpty()
        val documentEmpty = signUpBinding.signUpDocument.editText?.text.isNullOrEmpty()
        val passwordEmpty = signUpBinding.signUpPassword.editText?.text.isNullOrEmpty()
        val retypePasswordEmpty = signUpBinding.signUpRetypePassword.editText?.text.isNullOrEmpty()

        val buttonEnabled = !loginEmpty && !documentEmpty && !passwordEmpty && !retypePasswordEmpty

        signUpBinding.signUpCreate.toggleEnabled(isEnabled = buttonEnabled)
    }

    private fun createAccount() {
        toast(getString(R.string.signUp_result_accountCreated))
        finishAfterTransition()
    }
}