package com.yjy.idw.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.yjy.idw.R
import kotlinx.android.synthetic.main.activity_tournament_create.*

class TournamentCreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tournament_create)
        initializedEventListener()
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
                tournament_create_public_bt.background = getDrawable(R.drawable.push_button_border_line)
            }

            R.id.tournament_create_private_bt -> {
                tournament_create_public_bt.background = getDrawable(R.drawable.button_border_line)
                tournament_create_passwd_et.visibility = View.VISIBLE
                tournament_create_private_bt.background = getDrawable(R.drawable.push_button_border_line)
            }
        }
    }
}