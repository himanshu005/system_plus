package com.android.assignment.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import com.android.assignment.info.MoreInfoActivity
import com.android.assignment.R
import com.android.assignment.model.Constants
import com.android.assignment.model.ResultsItem
import com.android.assignment.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.app.Activity
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager


class MainActivity(override var mPresenter: MainContract.Presenter = MainPresenter()) : BaseMvpActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {

    private lateinit var mResultsItem: ArrayList<ResultsItem>
    private lateinit var mAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        mResultsItem = ArrayList()
        mAdapter = MovieAdapter(mResultsItem) {
            val intent = Intent(this, MoreInfoActivity::class.java)
            intent.putExtra(Constants.MOVIE_ID, "${it.id}")
            startActivity(intent)
        }
        recyclerView.adapter = mAdapter

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        etMovieName.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN) {
                when (keyCode) {
                    KeyEvent.KEYCODE_DPAD_CENTER, KeyEvent.KEYCODE_ENTER -> {
                        onSearch()
                        return@OnKeyListener true
                    }
                    else -> {}
                }
            }
            false
        })
    }

    fun onMovieClick(view : View) {
        onSearch()
    }

    private fun onSearch() {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)

        if (!etMovieName.text.isEmpty()) {
            mPresenter.loadMovies(etMovieName.text.toString())

            layoutContent.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }
    }


    override fun showMovies(repositories: List<ResultsItem>) {
        layoutContent.visibility=View.VISIBLE
        progressBar.visibility=View.GONE
        mAdapter.replaceData(repositories)
    }
}