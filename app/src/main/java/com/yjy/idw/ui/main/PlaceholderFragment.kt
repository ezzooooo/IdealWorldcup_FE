package com.yjy.idw.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.yjy.idw.R
import com.yjy.idw.ui.MainActivity
import com.yjy.idw.ui.RankingActivity

class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        Fragment가 살아있는 동안 ViewModelProvider를 생성
        생성이 완료되면 초기 Index 설정
         */
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 0)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_walk_through, container, false) // Fragment View

        val typedArray = context?.resources?.obtainTypedArray(R.array.walkthrough_images) // 워크스루 액티비티에 넣을 이미지 어레이 (values/arrays.xml에 있음)

        /*
        ViewModel의 LiveData<String> maintext가 변경되면 maintextView의 텍스트를 변경
         */
        val maintextView: TextView = root.findViewById(R.id.walk_through_main_text)
        pageViewModel.maintext.observe(this, Observer<String> {
            maintextView.text = arguments?.getString(ARG_MAINTEXT)
        })

        /*
        ViewModel의 LiveData<String> subtext가 변경되면 subtextView의 텍스트를 변경
         */
        val subtextView: TextView = root.findViewById(R.id.walk_through_sub_text)
        pageViewModel.subtext.observe(this, Observer<String> {
            subtextView.text = arguments?.getString(ARG_SUBTEXT)
        })

        /*
        ImageView와 버튼 객체를 layout과 연결
         */
        val imageView: ImageView = root.findViewById(R.id.walk_through_image)
        val button: Button = root.findViewById(R.id.walk_through_button)

        /*
        랭킹 액티비티가 오픈되게 해놨음
         */
        button.setOnClickListener {
            val nextIntent = Intent(context, com.yjy.idw.ui.MainActivity::class.java)
            startActivity(nextIntent)
            activity?.finish()
        }

        /*
        1. index가 변경될때마다 Image 변경
        2. index가 3일 때(0, 1, 2, 3) 버튼이 보이게 설정.
         */
        pageViewModel._index.observe(this, Observer<Int> {
            val index = arguments?.getInt(ARG_SECTION_NUMBER) ?: 0
            if (typedArray != null) {
                Glide.with(this).load(typedArray.getResourceId(index, 0)).into(imageView)
            }

            if (index == 3) {
                button.visibility = View.VISIBLE
            } else {
                button.visibility = View.INVISIBLE
            }
        })

        return root
    }

    companion object {
        /*
        Bundle에 넣을 키 값 선언
         */
        private const val ARG_SECTION_NUMBER = "section_number"
        private const val ARG_MAINTEXT = "maintext"
        private const val ARG_SUBTEXT = "subtext"

        /*
        PagerAdapter와 연결되는 부분으로 새 객체가 생성될 때 필요한 데이터를 넘겨주는 부분.
        현재는 Index, MainText, subText 3가지
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int, mainText: String, subText: String): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                    putString(ARG_MAINTEXT, mainText)
                    putString(ARG_SUBTEXT, subText)
                }
            }
        }
    }
}