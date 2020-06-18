package com.yjy.idw.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yjy.idw.api.UserAPI
import com.yjy.idw.data.UserVO
import com.yjy.idw.util.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.SearchView
import com.yjy.idw.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)

        main_search_iv.setOnSearchClickListener {  
            main_application_name.visibility = View.INVISIBLE
            main_action_menu.visibility = View.INVISIBLE
        }

        main_search_iv.setOnCloseListener {
            main_application_name.visibility = View.VISIBLE
            main_action_menu.visibility = View.VISIBLE
            false
        }

    }


}
