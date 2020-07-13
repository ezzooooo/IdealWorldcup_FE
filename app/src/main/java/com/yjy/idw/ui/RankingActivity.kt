package com.yjy.idw.ui

import MyAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.yjy.idw.R
import com.yjy.idw.data.RankingVO
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.main_action_menu
import kotlinx.android.synthetic.main.activity_main.main_application_name
import kotlinx.android.synthetic.main.activity_main.main_navigation_view
import kotlinx.android.synthetic.main.activity_main.main_search_iv
import kotlinx.android.synthetic.main.activity_main.main_toolbar
import kotlinx.android.synthetic.main.activity_ranking.*

class RankingActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var rankingList = arrayListOf<RankingVO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        setSupportActionBar(main_toolbar)

        // SWIPE로 메뉴 여는 행위 잠금
        ranking_drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        ranking_navigation_view.setNavigationItemSelectedListener (this)

        // Search View 눌렀을 때, Tool bar에 앱 타이틀, 메뉴 버튼 제거
        ranking_search_iv.setOnSearchClickListener {
            ranking_application_name.visibility = View.INVISIBLE
            ranking_action_menu.visibility = View.INVISIBLE
        }

        // Search View 닫았을 때, Tool bar에 앱 타이틀, 메뉴 버튼 추가
        ranking_search_iv.setOnCloseListener {
            ranking_application_name.visibility = View.VISIBLE
            ranking_action_menu.visibility = View.VISIBLE
            false
        }

        ranking_action_menu.setOnClickListener {
            ranking_drawer_layout.openDrawer(Gravity.LEFT)
        }

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(this, rankingList)

        recyclerView = findViewById<RecyclerView>(R.id.ranking_list_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

        rankingList.add(
            RankingVO(
                "https://i.pinimg.com/736x/0b/2f/8a/0b2f8a51314ab1ebe0505aee843a33b1.jpg",
                "100",
            "아이유 너무너무 이쁘다♥",
                "88.12%",
                "95.11%"
            )
        )

        rankingList.add(
            RankingVO(
                "https://i.pinimg.com/736x/0b/2f/8a/0b2f8a51314ab1ebe0505aee843a33b1.jpg",
                "100",
                "아이유 너무너무 이쁘다♥",
                "88.12%",
                "95.11%"
            )
        )

        rankingList.add(
            RankingVO(
                "https://i.pinimg.com/736x/0b/2f/8a/0b2f8a51314ab1ebe0505aee843a33b1.jpg",
                "100",
                "아이유 너무너무 이쁘다♥",
                "88.12%",
                "95.11%"
            )
        )
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_create_tournament -> {
                Toast.makeText(this.applicationContext, "클릭하였다.", Toast.LENGTH_SHORT).show()
                ranking_drawer_layout.closeDrawer(Gravity.LEFT)
                val intent = Intent(applicationContext, TournamentCreatePopupActivity::class.java)
                startActivity(intent)
            }
            R.id.action_my_create_tournament -> {
                Toast.makeText(this.applicationContext, "클릭하였다.", Toast.LENGTH_SHORT).show()
                ranking_drawer_layout.closeDrawer(Gravity.LEFT)
                val intent = Intent(applicationContext, RankingActivity::class.java)
                startActivity(intent)
            }
        }

        return true
    }
}