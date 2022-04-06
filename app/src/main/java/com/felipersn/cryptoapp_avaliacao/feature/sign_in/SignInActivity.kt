package com.felipersn.cryptoapp_avaliacao.feature.sign_in

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.felipersn.cryptoapp_avaliacao.common.extensions.toggleEnabled
import com.felipersn.cryptoapp_avaliacao.databinding.ActivitySignInBinding
import com.felipersn.cryptoapp_avaliacao.feature.home.HomeActivity
import com.felipersn.cryptoapp_avaliacao.feature.sign_up.SignUpActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var signInBinding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signInBinding = ActivitySignInBinding.inflate(layoutInflater)
        val view = signInBinding.root
        setContentView(view)

        initView()
    }

    private fun initView() {
        setupListeners()

        // Ensure that login button starts disabled to force
        // user to fill the fields before click
        checkFieldsAndToggleButton()
    }

    private fun setupListeners() {
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