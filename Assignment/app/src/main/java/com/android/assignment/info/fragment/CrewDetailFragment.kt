package com.android.assignment.info.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.assignment.R
import com.android.assignment.info.adapter.CrewAdapter
import com.android.assignment.model.CrewItem

class CrewDetailFragment : Fragment() {
    private lateinit var mAdapter: CrewAdapter

    companion object {
        private var crews: List<CrewItem>? = null

        fun newInstance(crews: List<CrewItem>?): CrewDetailFragment {
            this.crews = crews
            return CrewDetailFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.detail_fragment, container, false)
        val rvDetail: RecyclerView = view.findViewById(R.id.reDetail)
        mAdapter = CrewAdapter(crews)

        rvDetail.layoutManager = GridLayoutManager(view.context, 2)
        rvDetail.adapter = mAdapter
        return view
    }
}