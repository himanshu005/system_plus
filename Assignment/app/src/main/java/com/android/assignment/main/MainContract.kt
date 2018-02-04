package com.android.assignment.main

import com.android.assignment.model.ResultsItem
import com.android.assignment.mvp.BaseMvpPresenter
import com.android.assignment.mvp.BaseMvpView

object MainContract {
    interface View : BaseMvpView {
        fun showMovies(repositories: List<ResultsItem>)

    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadMovies(movieName :String)

    }
}