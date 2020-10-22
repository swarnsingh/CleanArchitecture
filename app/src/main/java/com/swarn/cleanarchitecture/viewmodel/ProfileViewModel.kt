package com.swarn.cleanarchitecture.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.swarn.cleanarchitecture.data.cache.SessionManager
import com.swarn.cleanarchitecture.domain.model.User
import javax.inject.Inject

/**
 * @author Swarn Singh.
 */
class ProfileViewModel @Inject constructor(sessionManager: SessionManager) : ViewModel() {

    private val TAG = ProfileViewModel::class.java.canonicalName

    private var sessionManager: SessionManager

    init {
        Log.d(TAG, "ProfileViewModel is ready")
        this.sessionManager = sessionManager
    }

    fun getAuthenticatedUser(): LiveData<User> {
        return sessionManager.getAuthUser()
    }
}