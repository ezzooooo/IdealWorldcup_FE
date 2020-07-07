package com.yjy.idw.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.yjy.idw.R

/*
토너먼트 몇 강인지 선택할 수 있는 팝업 액티비티
 */

class TournamentCreatePopupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tournament_create_popup)
    }

    // 바깥 레이어 클릭 시 안닫히히게
   override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event?.action == MotionEvent.ACTION_OUTSIDE) return false
        return true
    }
}