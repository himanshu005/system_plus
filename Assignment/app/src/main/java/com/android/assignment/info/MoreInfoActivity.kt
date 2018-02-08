package com.android.assignment.info

import android.os.Bundle
import com.android.assignment.R
import com.android.assignment.info.adapter.MoviesPagerAdapter
import com.android.assignment.model.Constants
import com.android.assignment.model.Credits
import com.android.assignment.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_more_info.*

class MoreInfoActivity (override var mPresenter: MoreInfoContract.Presenter = MoreInfoPresenter()) : BaseMvpActivity<MoreInfoContract.View, MoreInfoContract.Presenter>(), MoreInfoContract.View {
    private lateinit var mCredits: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)

        val movieId = intent.getStringExtra(Constants.MOVIE_ID)
                ?: throw IllegalStateException(getString(R.string.field_movie_id_missing))
        mPresenter.loadCredits(movieId)
    }

    override fun showCredits(credits: Credits) {
        initViewPager(credits)
    }


    private fun initViewPager(credits: Credits) {
        mCredits = arrayListOf(getString(R.string.crew), getString(R.string.cast))
        val pagerAdapter = MoviesPagerAdapter(supportFragmentManager, mCredits,credits)
        viewPager.adapter = pagerAdapter
        recyclerTabLayout.setUpWithViewPager(viewPager)
    }
}
