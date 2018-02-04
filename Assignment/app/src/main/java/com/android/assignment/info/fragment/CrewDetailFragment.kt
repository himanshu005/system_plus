package com.android.assignment.info.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.assignment.R
import com.android.assignment.info.Adapter.CastAdapter
import com.android.assignment.info.Adapter.CrewAdapter
import com.android.assignment.model.CastItem
import com.android.assignment.model.CrewItem

class CrewDetailFragment : Fragment() {
    private lateinit var adapter: CrewAdapter

    companion object {
        private var crews: List<CrewItem>? = null

        fun newInstance(crews: List<CrewItem>?): CrewDetailFragment {
            this.crews = crews
            return CrewDetailFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.detail_fragment, container, false);
        val reDetail: RecyclerView = view.findViewById<RecyclerView>(R.id.reDetail)
        adapter = CrewAdapter(crews)

        reDetail.layoutManager = GridLayoutManager(view.context, 2) as RecyclerView.LayoutManager?
        reDetail.adapter = adapter
        return view
    }
}