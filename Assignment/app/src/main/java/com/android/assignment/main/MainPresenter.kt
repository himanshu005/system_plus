package com.android.assignment.main

import android.annotation.SuppressLint
import android.util.Log
import com.android.assignment.model.Movie
import com.android.assignment.model.network.ApiManager
import com.android.assignment.mvp.BaseMvpPresenterImpl

class MainPresenter: BaseMvpPresenterImpl<MainContract.View>(), MainContract.Presenter {

    @SuppressLint("CheckResult")
    override fun loadMovies(movieName: String) {
        ApiManager.loadMovies(movieName)
                .doOnError { mView?.showMessage(it.toString()) }
                .subscribe(this::handleMovieResponse, this::handleError)
    }
    private fun handleMovieResponse(movieList: Movie) {
        mView?.showMovies(movieList.results!!)
    }

    private fun handleError(error: Throwable) {
    }
}