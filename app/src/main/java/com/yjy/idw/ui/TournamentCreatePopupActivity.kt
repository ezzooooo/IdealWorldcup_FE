package com.yjy.idw.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.Window
import com.yjy.idw.R

/*
토너먼트 몇 강인지 선택할 수 있는 팝업 액티비티
 */

class TournamentCreatePopupActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tournament_create_popup)
    }

    // 바깥 레이어 클릭 시 안닫히히게
   override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event?.action == MotionEvent.ACTION_OUTSIDE) return false
        return true
    }
}