package com.android.assignment.info

import android.os.Bundle
import android.util.Log
import com.android.assignment.R
import com.android.assignment.info.Adapter.MoviesPagerAdapter
import com.android.assignment.model.Constants
import com.android.assignment.model.Credits
import com.android.assignment.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_more_info.*

class MoreInfoActivity (override var mPresenter: MoreInfoContract.Presenter = MoreInfoPresenter()) : BaseMvpActivity<MoreInfoContract.View, MoreInfoContract.Presenter>(), MoreInfoContract.View {

    private val TAG = MoreInfoActivity::class.java.simpleName

    private lateinit var mCredits: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)

        val movieId = intent.getStringExtra(Constants.MOVIE_ID)
                ?: throw IllegalStateException(getString(R.string.field_movie_id_missing))
        mPresenter.loadCredits(movieId)
    }

    override fun showCredits(credits: Credits) {
        Log.v(TAG, credits.toString())
        initViewPager(credits)

    }


    private fun initViewPager(credits: Credits) {
        mCredits = arrayListOf("Crew", "Cast")
        val pagerAdapter = MoviesPagerAdapter(supportFragmentManager, mCredits,credits)
        viewPager.adapter = pagerAdapter
        recyclerTabLayout.setUpWithViewPager(viewPager)
    }
}
