package com.mikekrysan.module28_8

import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment: Fragment() {
//    init {
//        enterTransition = Slide(Gravity.END).apply { duration = 800 }
//        returnTransition = Slide(Gravity.END).apply { duration = 800;mode = Slide.MODE_OUT }
//    }


//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//       return inflater.inflate(R.layout.fragment_second, container, false)
//    }

    var imageIndex = 0;
    var text: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Приостанавливаем воспроизведение Transition до загрузки данных
        postponeEnterTransition()
        val imageIds = arrayOf(
            R.drawable.bus,
            R.drawable.subway,
            R.drawable.walk,
            R.drawable.dutch_bike,
            R.drawable.city_car,
            R.drawable.airplane
        )
        image.setImageResource(imageIds[imageIndex])
        text_name.text = text
        //Данные загружены, запускаем анимацию перехода
        startPostponedEnterTransition()
    }
}