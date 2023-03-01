package com.mikekrysan.module28_8

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.Slide
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.page.*

const val transitionName = "image_name"
const val transitionNameText = "transition_text"

const val KEY_IMAGE_INDEX = "image_index"
const val KEY_TEXT = "text_index"

class MainFragment: Fragment() {

//    init {
//        exitTransition = Slide(Gravity.START).apply { duration = 800;mode = Slide.MODE_OUT }
//        reenterTransition = Slide(Gravity.START).apply { duration = 800; }
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        return inflater.inflate(R.layout.main_fragment, container, false)
//    }
//
//    override fun onStart() {
//        super.onStart()
//        view?.setOnClickListener {
//            val a = activity as FragmentActivity
//            a.supportFragmentManager.beginTransaction().replace(R.id.container, SecondFragment()).addToBackStack("MainFragment").commit()
//        }
//    }

    //Shared-Element Fragment Transition

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    val secondFragment = SecondFragment()

    init {
        secondFragment.sharedElementEnterTransition = AutoTransition().setDuration(800L)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val texts = arrayOf(t1, t2, t3, t4, t5, t6)
        val images = arrayOf(i1, i2, i3, i4, i5, i6)

//        view.setOnClickListener {
//            val a = activity as FragmentActivity
//            a.supportFragmentManager.beginTransaction().replace(R.id.root, SecondFragment()).addToBackStack("MainFragment").commit()
//        }
        images.forEachIndexed { i, img ->
            img.setOnClickListener {
                //Очищаем transitionName для views прошлого перехода
                images[secondFragment.imageIndex].transitionName = ""
                texts[secondFragment.imageIndex].transitionName = ""
                //Ставим transitionName для views текущего перехода
                img.transitionName = transitionName
                texts[i].transitionName = transitionNameText
                parentFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .addSharedElement(img, transitionName)
                    .addSharedElement(texts[i], transitionNameText)
                    .replace((view.parent as ViewGroup).id, secondFragment.apply {
                        imageIndex = i;
                        text = texts[i].text.toString()
                    })
                    .addToBackStack("MainFragment")
                    .commit()
            }
        }
    }
}