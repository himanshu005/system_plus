package com.android.assignment.info

import android.util.Log
import com.android.assignment.main.MainPresenter
import com.android.assignment.model.Credits
import com.android.assignment.model.network.ApiManager
import com.android.assignment.mvp.BaseMvpPresenterImpl

class MoreInfoPresenter : BaseMvpPresenterImpl<MoreInfoContract.View>(), MoreInfoContract.Presenter {
    private val TAG = MainPresenter::class.java.simpleName

    override fun loadCredits(movieID: String) {
        ApiManager.loadCredits(movieID)
                .doOnError { mView?.showMessage(it.toString()) }
                .subscribe(this::handleMovieResponse, this::handleError)
    }
    private fun handleMovieResponse(credit: Credits) {
        Log.v(TAG, credit.toString())
        mView?.showCredits(credit)
    }

    private fun handleError(error: Throwable) {
        Log.v(TAG,error.toString())
    }

}