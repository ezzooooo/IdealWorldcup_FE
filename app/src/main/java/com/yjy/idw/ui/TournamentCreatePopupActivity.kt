package com.yjy.idw.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.widget.Button
import com.yjy.idw.R
import kotlinx.android.synthetic.main.activity_tournament_create_popup.*

/*
토너먼트 몇 강인지 선택할 수 있는 팝업 액티비티
 */

class TournamentCreatePopupActivity : Activity() {

    // 이전에 어떤 버튼이 눌러져 있었는지 알 수 있도록 선언한 배열과 변수
    lateinit var round_list : Array<View>
    var BeforePushButton = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tournament_create_popup)
        round_list = arrayOf(findViewById(R.id.tournament_create_8_bt), findViewById(R.id.tournament_create_16_bt), findViewById(R.id.tournament_create_64_bt), findViewById(R.id.tournament_create_128_bt))
        initializedEventListener()
    }

    // 바깥 레이어 클릭 시 안닫히히게
   override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event?.action == MotionEvent.ACTION_OUTSIDE) return false
        return true
    }

    fun initializedEventListener() {
        tournament_create_bt.setOnClickListener {
            val intent = Intent(this.applicationContext, TournamentCreateActivity::class.java)
            startActivity(intent)
        }

        tournament_create_8_bt.setOnClickListener {
            onTouchEventForRoundButtom(it)
        }

        tournament_create_16_bt.setOnClickListener {
            onTouchEventForRoundButtom(it)
        }

        tournament_create_64_bt.setOnClickListener {
            onTouchEventForRoundButtom(it)
        }

        tournament_create_128_bt.setOnClickListener {
            onTouchEventForRoundButtom(it)
        }
    }

    fun onTouchEventForRoundButtom(view : View) {
        round_list[BeforePushButton].background = getDrawable(R.drawable.button_border_line)

        when(view.id) {
            R.id.tournament_create_8_bt -> {
                BeforePushButton = 0
            }
            R.id.tournament_create_16_bt -> {
                BeforePushButton = 1
            }
            R.id.tournament_create_64_bt -> {
                BeforePushButton = 2
            }
            R.id.tournament_create_128_bt -> {
                BeforePushButton = 3
            }
        }

        round_list[BeforePushButton].background = getDrawable(R.drawable.push_button_border_line)
    }
}