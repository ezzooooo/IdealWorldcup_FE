package com.yjy.idw.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yjy.idw.R

private val TAB_MainText = arrayOf(
    R.string.WalkThroughMainText1,
    R.string.WalkThroughSubText1,
    R.string.WalkThroughMainText1,
    R.string.WalkThroughMainText1
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1, context.resources.getString(
            TAB_MainText[position]))
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_MainText[position])
    }

    override fun getCount(): Int {
        return 4
    }
}