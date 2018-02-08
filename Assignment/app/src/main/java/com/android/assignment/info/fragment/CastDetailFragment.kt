package com.android.assignment.info.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.assignment.R
import com.android.assignment.info.adapter.CastAdapter
import com.android.assignment.model.CastItem

class CastDetailFragment : Fragment() {
    private lateinit var mAdapter: CastAdapter

    companion object {
        private var casts: List<CastItem>? = null

        fun newInstance(casts: List<CastItem>?): CastDetailFragment {
            this.casts = casts
            return CastDetailFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.detail_fragment, container, false)
        val reDetail: RecyclerView = view.findViewById(R.id.reDetail)
        mAdapter = CastAdapter(casts)

        reDetail.layoutManager = GridLayoutManager(view.context, 2)
        reDetail.adapter = mAdapter
        return view
    }
}