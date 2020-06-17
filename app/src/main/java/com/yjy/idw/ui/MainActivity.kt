package com.yjy.idw.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import android.util.Log
import com.yjy.idw.R
import com.yjy.idw.api.UserAPI
import com.yjy.idw.data.UserVO
import com.yjy.idw.util.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
=======
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import com.yjy.idw.R
import kotlinx.android.synthetic.main.activity_main.*
>>>>>>> cb63b7a126423c8b9f98fb947b3014f617fd3d24

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
<<<<<<< HEAD

        val retrofit = RetrofitFactory.getRetrofit()

        val userAPI = retrofit.create(UserAPI::class.java)

        userAPI.getUserList().enqueue(object : Callback<List<UserVO>> {
            override fun onFailure(call: Call<List<UserVO>>, t: Throwable) {
                Log.d("실패", "유저리스트 가져오기 실패")
            }

            override fun onResponse(call: Call<List<UserVO>>, response: Response<List<UserVO>>) {
                if(response.isSuccessful) {
                    val user = response.body()
                    Log.d("성공", user.toString())
                }
            }
        })
=======
        setSupportActionBar(main_toolbar)
>>>>>>> cb63b7a126423c8b9f98fb947b3014f617fd3d24
    }
}
