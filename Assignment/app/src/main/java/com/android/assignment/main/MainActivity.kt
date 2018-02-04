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
import android.view.inputmethod.InputMethodManager.HIDE_IMPLICIT_ONLY
import android.app.Activity
import android.view.inputmethod.InputMethodManager


class MainActivity(override var mPresenter: MainContract.Presenter = MainPresenter()) : BaseMvpActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {
    private val mTag = MainActivity::class.java.simpleName

    private lateinit var resultsItem: ArrayList<ResultsItem>
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        resultsItem = ArrayList()
        adapter = MovieAdapter(resultsItem) {
            val intent = Intent(this, MoreInfoActivity::class.java)
            intent.putExtra(Constants.MOVIE_ID, "${it.id}")
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
    fun onMovieClick(view : View) {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm!!.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)

        if(!etMovieName.text.isEmpty()){
            mPresenter.loadMovies(etMovieName.text.toString())

            layoutContent.visibility=View.GONE
            progressBar.visibility=View.VISIBLE
        }

    }
    override fun showMovies(repositories: List<ResultsItem>) {
        Log.v(mTag, repositories.toString())
        layoutContent.visibility=View.VISIBLE
        progressBar.visibility=View.GONE
        adapter.replaceData(repositories)
    }
}