package com.example.android.tappui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.meaing_screen_1.view.*
import kotlinx.android.synthetic.main.meaning_screen_2.view.*


class MeaningAdapter(
    private val wordObject: WordObjectContainer,
    private val context: Context
) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun getCount(): Int = 2

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        if ( position== 0 ){

            val view = LayoutInflater.from( context )
                .inflate( R.layout.meaing_screen_1 , container , false )

            // Bind Data for First Layout
            view.tv_english_meaning.text = wordObject.data?.wordEnglish
            view.tv_hindi_meaning.text = wordObject.data?.wordMeaningTranslated?.get(0) ?: ""

            view.tv_detail_explanation_h.text = wordObject.data?.imageDescTranslated?.get(0).toString() ?: ""
            view.tv_detail_explanation_e.text = wordObject.data?.imageDescEng?.get(0) ?: ""
            // Load Image
            val image = wordObject.compressLink?.plus(wordObject.data?.imageCompress?.get(0))
            Glide.with(context).load(image)
                .into(view.word_image)

            container.addView(view.meaning_1_container)
            return view

        }else{

            val view = LayoutInflater.from( context )
                .inflate( R.layout.meaning_screen_2 , container , false )

            // Bind Data for Second Layout
            view.tv_word_title.text = wordObject.data?.wordEnglish ?: ""
            wordObject.data?.wordMoreMeaningTranslated?.forEach{  s ->
                view.tv_more_meanings.append(s?.replace("\\s+", " ").toString().plus("\n"))
            }
            wordObject.data?.wordMeaningEng?.forEach{  s ->
                view.tv_words_define.append(s?.replace("\\s+", " ").toString().plus("\n"))
            }
            /*wordObject.data?.wordAntonym?.forEach{  s ->
                view.tv_words_antonym.append(s?.replace("\\s+", " ").toString().plus("\n"))
            }
            wordObject.data?.wordSynonym?.forEach{  s ->
                val item = s?.replace("\\s+", " ").toString().plus("\n")
                view.tv_words_synonym.append(item)
            }*/

            container.addView(view.meaning_2_container)

            return view

        }

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)

    }

}