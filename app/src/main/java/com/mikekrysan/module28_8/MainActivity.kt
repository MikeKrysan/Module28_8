package com.mikekrysan.module28_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.main_activity.*

const val NUM_PAGES = 5

class MainActivity : AppCompatActivity() {

    //Анимированный переход между фрагментами:
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        //Обычный переход между фрагментами
//        //Для начала запустим стартовый фрагмент:
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, MainFragment())
//                .addToBackStack("MainFragment")
//                .commit()
//        }
//    }

    //Пример ViewPager
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_activity)
//
//        val pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
//        view_pager.adapter = pagerAdapter
//        //Теперь можно установить объект данного класса как PageTransformer для созданного ViewPager
//        view_pager.setPageTransformer(true, ZoomPageTransformer())
//    }
//
//    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
//        override fun getCount(): Int = NUM_PAGES
//
//        override fun getItem(position: Int): Fragment = PageFragment(position)
//    }

    //Shared-Element Fragment Transition
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportFragmentManager.beginTransaction()
            .replace(R.id.root, MainFragment())
            .commit()
    }
}