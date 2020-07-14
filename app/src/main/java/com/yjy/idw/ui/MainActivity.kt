package com.yjy.idw.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.*
import com.yjy.idw.api.UserAPI
import com.yjy.idw.data.UserVO
import com.yjy.idw.util.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.SearchView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.yjy.idw.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)

        // SWIPE로 메뉴 여는 행위 잠금
        main_drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        main_navigation_view.setNavigationItemSelectedListener (this)

        // Search View 눌렀을 때, Tool bar에 앱 타이틀, 메뉴 버튼 제거
        main_search_iv.setOnSearchClickListener {
            main_application_name.visibility = View.INVISIBLE
            main_action_menu.visibility = View.INVISIBLE
        }

        // Search View 닫았을 때, Tool bar에 앱 타이틀, 메뉴 버튼 추가
        main_search_iv.setOnCloseListener {
            main_application_name.visibility = View.VISIBLE
            main_action_menu.visibility = View.VISIBLE
            false
        }

        main_action_menu.setOnClickListener {
            main_drawer_layout.openDrawer(Gravity.LEFT)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_create_tournament -> {
                main_drawer_layout.closeDrawer(Gravity.LEFT)
                val intent = Intent(applicationContext, TournamentCreatePopupActivity::class.java)
                startActivity(intent)
            }
            R.id.action_my_create_tournament -> {
                main_drawer_layout.closeDrawer(Gravity.LEFT)
                val intent = Intent(applicationContext, RankingActivity::class.java)
                startActivity(intent)
            }
        }

        return true
    }
}
