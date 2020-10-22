package com.swarn.cleanarchitecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swarn.cleanarchitecture.data.cache.SessionManager
import com.swarn.cleanarchitecture.domain.model.User
import com.swarn.cleanarchitecture.domain.usecase.AuthenticateUseCase
import com.swarn.cleanarchitecture.vo.Resource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Swarn Singh.
 */
class AuthViewModel @Inject constructor(
    private val authenticateUseCase: AuthenticateUseCase,
    private val sessionManager: SessionManager
) : ViewModel() {
    private val disposables = CompositeDisposable()

    private val userData: LiveData<Resource<User>>
        get() = user

    private val user: MutableLiveData<Resource<User>> by lazy {
        MutableLiveData()
    }

    fun authenticateUser(userId: Int): LiveData<Resource<User>> {
        authenticateUseCase.queryUserId(userId)
            .toObservable()
            .observeOn(Schedulers.io())
            .subscribeWith(object : io.reactivex.Observer<User> {
                override fun onSubscribe(d: Disposable) {
                    user.value = Resource.Loading()
                }

                override fun onNext(t: User) {
                    sessionManager.authenticateWithId(t)
                    user.postValue(Resource.Success(t))
                }

                override fun onError(e: Throwable) {
                    sessionManager.authenticateWithId(null)
                    user.postValue(Resource.Error(e.localizedMessage))
                }

                override fun onComplete() {

                }
            })

        return userData
    }

    fun observeAuthState(): LiveData<User> {
        return sessionManager.getAuthUser()
    }
}