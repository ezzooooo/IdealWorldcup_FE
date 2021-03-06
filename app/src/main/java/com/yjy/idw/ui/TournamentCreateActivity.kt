package com.yjy.idw.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.yjy.idw.R
import kotlinx.android.synthetic.main.activity_tournament_create.*

class TournamentCreateActivity : AppCompatActivity() {

    private var round : Int = 8
    private val imageContainerList : ArrayList<View> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tournament_create)
        round = intent.getIntExtra("ROUND", 8)
        createViewForInsertImage()
        initializedEventListener()
    }

    private fun createViewForInsertImage() {
        val mInflater : LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val parent = findViewById<LinearLayout>(R.id.tournament_create_image_layout_container)

        var cnt = round / 2
        for(i in 0..cnt) {
            val view = mInflater.inflate(R.layout.tournament_image_container, parent, true)
            imageContainerList.add(view)
        }
    }

    private fun initializedEventListener() {
        tournament_create_private_bt.setOnClickListener {
            onTouchEventForPublicButton(it)
        }

        tournament_create_public_bt.setOnClickListener {
            onTouchEventForPublicButton(it)
        }
    }

    private fun onTouchEventForPublicButton(view: View) {
        when(view.id) {
            R.id.tournament_create_public_bt -> {
                tournament_create_passwd_et.visibility = View.INVISIBLE
                tournament_create_private_bt.background = getDrawable(R.drawable.button_border_line)
                tournament_create_private_bt.setTextColor(getColor(R.color.colorTextForNotPushButton))

                tournament_create_public_bt.background = getDrawable(R.drawable.push_button_border_line)
                tournament_create_public_bt.setTextColor(getColor(R.color.colorWordInColorPrimary))
            }

            R.id.tournament_create_private_bt -> {
                tournament_create_public_bt.background = getDrawable(R.drawable.button_border_line)
                tournament_create_public_bt.setTextColor(getColor(R.color.colorTextForNotPushButton))

                tournament_create_passwd_et.visibility = View.VISIBLE
                tournament_create_private_bt.background = getDrawable(R.drawable.push_button_border_line)
                tournament_create_private_bt.setTextColor(getColor(R.color.colorWordInColorPrimary))
            }
        }
    }
}