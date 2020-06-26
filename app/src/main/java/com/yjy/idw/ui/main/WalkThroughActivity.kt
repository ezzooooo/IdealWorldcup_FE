package com.yjy.idw.ui.main

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.yjy.idw.R
import com.yjy.idw.ui.main.SectionsPagerAdapter
import me.relex.circleindicator.CircleIndicator

class WalkThroughActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walk_through)
        
        /*
        어댑터와 뷰 페이저를 연결
         */
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter

        val indicator: CircleIndicator = findViewById(R.id.indicator)
        indicator.setViewPager(viewPager)
    }
}