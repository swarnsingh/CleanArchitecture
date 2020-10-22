package com.swarn.cleanarchitecture.ui

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.swarn.cleanarchitecture.R
import com.swarn.cleanarchitecture.util.isInteger
import com.swarn.cleanarchitecture.viewmodel.AuthViewModel
import com.swarn.cleanarchitecture.viewmodel.ViewModelProviderFactory
import com.swarn.cleanarchitecture.vo.Resource
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * @author Swarn Singh.
 */
class AuthActivity : DaggerAppCompatActivity() {

    private val TAG = AuthActivity::class.java.canonicalName

    private lateinit var authViewModel: AuthViewModel

    private lateinit var loginButton: Button

    private lateinit var userIdEditText: EditText

    private lateinit var progressBar: ProgressBar

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var logo: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        userIdEditText = findViewById(R.id.user_id_input)

        loginButton = findViewById(R.id.login_button)

        progressBar = findViewById(R.id.progress_bar)

        authViewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)

        loginButton.setOnClickListener {
            val value = userIdEditText.text.toString()
            if (!TextUtils.isEmpty(value)) {
                if (value.isInteger()) {
                    authViewModel.authenticateUser(userIdEditText.text.toString().toInt())
                        .observe(this, {
                            when (it) {
                                is Resource.Success -> {
                                    showProgressBar(false)
                                    onLoginSuccess()
                                    Log.d(TAG, "onChanged: Login Success: " + it.data?.email)
                                }
                                is Resource.Error -> {
                                    showProgressBar(false)
                                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                                }
                                else -> {
                                    showProgressBar(true)
                                }
                            }
                        })
                } else {
                    Toast.makeText(this, "Please Enter Integer only", Toast.LENGTH_SHORT).show()
                }
            }
        }
        setLogo()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        authViewModel.observeAuthState().observe(this, {
            if (it != null) {
                onLoginSuccess()
            }
        })
    }

    private fun showProgressBar(isVisible: Boolean) {
        if (isVisible) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    private fun setLogo() {
        requestManager.load(logo)
            .into(findViewById(R.id.login_logo))
    }

    private fun onLoginSuccess() {
        Intent(this, MainActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }
}