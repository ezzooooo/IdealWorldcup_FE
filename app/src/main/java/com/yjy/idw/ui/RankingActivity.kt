package com.yjy.idw.ui

import RankingAdapter
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

        ranking_action_menu.setOnClickListener {
            ranking_drawer_layout.openDrawer(Gravity.LEFT)
        }

        viewManager = LinearLayoutManager(this)
        viewAdapter = RankingAdapter(this, rankingList)

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
                ranking_drawer_layout.closeDrawer(Gravity.LEFT)
                val intent = Intent(applicationContext, TournamentCreatePopupActivity::class.java)
                startActivity(intent)
            }
            R.id.action_my_create_tournament -> {
                ranking_drawer_layout.closeDrawer(Gravity.LEFT)
                val intent = Intent(applicationContext, RankingActivity::class.java)
                startActivity(intent)
            }
        }

        return true
    }
}