package com.swarn.cleanarchitecture.data.cache

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.swarn.cleanarchitecture.domain.model.User
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Swarn Singh.
 */
@Singleton
class SessionManager @Inject constructor() {
    private val TAG = SessionManager::class.java.canonicalName

    private val cachedUser: MutableLiveData<User> by lazy {
        MutableLiveData()
    }

    private val cachedUserData: LiveData<User>
        get() = cachedUser

    fun authenticateWithId(source: User?) {
        cachedUser.postValue(source)
    }

    fun logout() {
        Log.d(TAG, "logOut: logging out...")
        cachedUser.postValue(null)
    }

    fun getAuthUser(): LiveData<User> {
        return cachedUserData
    }
}