package com.android.assignment.info

import android.annotation.SuppressLint
import com.android.assignment.model.Credits
import com.android.assignment.model.network.ApiManager
import com.android.assignment.mvp.BaseMvpPresenterImpl

class MoreInfoPresenter : BaseMvpPresenterImpl<MoreInfoContract.View>(), MoreInfoContract.Presenter {

    @SuppressLint("CheckResult")
    override fun loadCredits(movieID: String) {
        ApiManager.loadCredits(movieID)
                .doOnError { mView?.showMessage(it.toString()) }
                .subscribe(this::handleMovieResponse, this::handleError)
    }
    private fun handleMovieResponse(credit: Credits) {
        mView?.showCredits(credit)
    }

    private fun handleError(error: Throwable) {
    }

}