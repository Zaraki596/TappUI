package com.example.android.tappui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_meaning_screen.*

class MeaningScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meaning_screen)
        val adapter = MeaningAdapter(
            DataProvider.data,
            this
        )
        viewPager.adapter = adapter

    }
}
