package com.mikekrysan.module28_8

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.page.view.*

class PageFragment(var position: Int): Fragment() {
    val colors = arrayOf(Color.LTGRAY, Color.MAGENTA, Color.BLUE, Color.YELLOW, Color.GREEN)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.text.text = "${position + 1}"
        view.setBackgroundColor(colors[position])
    }
}