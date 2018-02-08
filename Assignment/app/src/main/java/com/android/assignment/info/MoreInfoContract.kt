package com.android.assignment.info

import com.android.assignment.model.Credits
import com.android.assignment.mvp.BaseMvpPresenter
import com.android.assignment.mvp.BaseMvpView

object MoreInfoContract {
    interface View : BaseMvpView {
        fun showCredits(credits: Credits)

    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadCredits(movieID :String)

    }
}