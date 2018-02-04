package com.android.assignment.info.Adapter


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.android.assignment.info.fragment.CastDetailFragment
import com.android.assignment.info.fragment.CrewDetailFragment
import com.android.assignment.model.Credits

class MoviesPagerAdapter(fragmentManager: FragmentManager, private val credits: ArrayList<String> ,var creditsData: Credits) :
        FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
      if (position==0){
          return CrewDetailFragment.newInstance(creditsData.crew)
      }else{
          return CastDetailFragment.newInstance(creditsData.cast)
      }

    }
    override fun getPageTitle(position: Int): CharSequence {
        return credits[position % credits.size]
    }
    override fun getCount(): Int {
        return credits.size
    }
}