package com.swarn.cleanarchitecture

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.swarn.cleanarchitecture.data.cache.SessionManager
import com.swarn.cleanarchitecture.ui.AuthActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * @author Swarn Singh.
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    private val TAG = BaseActivity::class.java.canonicalName

    @Inject
    lateinit var sessionManager: SessionManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeObservers()
    }

    private fun subscribeObservers() {

        sessionManager.getAuthUser().observe(this, Observer {
            if (it == null) {
                navLoginScreen()
            }
        })
    }

    private fun navLoginScreen() {
        Intent(this, AuthActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }
}