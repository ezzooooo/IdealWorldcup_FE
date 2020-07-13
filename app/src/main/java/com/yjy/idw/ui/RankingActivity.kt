package com.yjy.idw.ui

import MyAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yjy.idw.R
import com.yjy.idw.data.RankingVO

class RankingActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var rankingList = arrayListOf<RankingVO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

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
}