package com.rk_softwares.textwithsubtext

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.graphics.toColorInt

class TextWithSubText(context: Context, attrs : AttributeSet?) : RelativeLayout(context, attrs) {

    private var mText : AppCompatTextView
    private var sText : AppCompatTextView
    private var ivEnd : AppCompatImageView
    private var ivStart : AppCompatImageView

    init {

        LayoutInflater.from(context).inflate(R.layout.lay_main_sub_text, this, true)

        mText = findViewById(R.id.tv_main)
        sText = findViewById(R.id.tv_sub)
        ivEnd = findViewById(R.id.iv_end)
        ivStart = findViewById(R.id.iv_start)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.TextWithSubText)

        val mainText = attributes.getString(R.styleable.TextWithSubText_mainText) ?: ""
        val mainTextSize = attributes.getDimension(R.styleable.TextWithSubText_mainTextSize, 15f)
        val mainTextColor = attributes.getColor(R.styleable.TextWithSubText_mainTextColor, Color.parseColor("#000000"))
        val mainTextStyle = attributes.getInt(R.styleable.TextWithSubText_mainTextStyle, 0)

        val subText = attributes.getString(R.styleable.TextWithSubText_subText) ?: ""
        val subTextSize = attributes.getDimension(R.styleable.TextWithSubText_subTextSize, 12f)
        val subTextColor = attributes.getColor(R.styleable.TextWithSubText_subTextColor, Color.parseColor("#807575"))
        val subTextStyle = attributes.getInt(R.styleable.TextWithSubText_subTextStyle, 0)

        val drawableStart = attributes.getResourceId(R.styleable.TextWithSubText_drawableStart, 0)
        val drawableEnd = attributes.getResourceId(R.styleable.TextWithSubText_drawableEnd, 0)
        val drawablePadding = attributes.getDimensionPixelSize(R.styleable.TextWithSubText_drawablePadding, 0)

        attributes.recycle()

        mText.text = mainText
        mText.textSize = mainTextSize
        mText.setTextColor(mainTextColor)

        mText.setTypeface(null, when(mainTextStyle) {

            1 -> Typeface.ITALIC
            2-> Typeface.BOLD
            else -> Typeface.NORMAL

        })

        sText.text = subText
        sText.textSize = subTextSize
        sText.setTextColor(subTextColor)

        sText.setTypeface(null, when(subTextStyle) {

            1 -> Typeface.ITALIC
            2-> Typeface.BOLD
            else -> Typeface.NORMAL

        })

        image(drawableStart, ivStart)
        image(drawableEnd, ivEnd)

        drawablePaddings(drawablePadding, mText, sText, drawableStart, 0)
        drawablePaddings(drawablePadding, mText, sText, 0, drawableEnd)

    } // init end==============================================================

    //For Java or Kotlin
    fun setMainText(text : String){

        mText.text = text

    }

    //For Java or Kotlin
    fun setMainTextSize(textSize : Int){

        mText.textSize = textSize.toFloat()

    }

    //For Java or Kotlin
    fun setMainTextColor(colorString : String ){

        try {

            mText.setTextColor(colorString.toColorInt())

        }catch (e : Exception){

            e.printStackTrace()

        }

    }

    //For Java or Kotlin
    fun setMainTextStyle(style : Int){

        mText.setTypeface(null, style)

    }

    //For Java or Kotlin
    fun setSubText(text : String){

        sText.text = text

    }

    //For Java or Kotlin
    fun setSubTextSize(textSize : Int){

        sText.textSize = textSize.toFloat()

    }

    //For Java or Kotlin
    fun setSubTextColor(colorString : String){

        try {

            sText.setTextColor(colorString.toColorInt())

        }catch (e : Exception){

            e.printStackTrace()

        }

    }

    //For Java or Kotlin
    fun setSubTextStyle(style: Int){

        sText.setTypeface(null, style)

    }

    //For Java or Kotlin
    fun drawableStart(drawable: Int = 0){

        if (drawable != 0){

            ivStart.visibility = View.VISIBLE
            ivStart.setImageResource(drawable)
            drawablePadding(0)

        }else{

            ivStart.visibility = View.GONE

        }

    }

    //For Java or Kotlin
    fun drawableEnd(drawable: Int = 0){

        if (drawable != 0){

            ivEnd.visibility = View.VISIBLE
            ivEnd.setImageResource(drawable)
            drawablePadding(0)

        }else{

            ivEnd.visibility = View.GONE

        }

    }

    //For XML or Java or Kotlin
    fun drawablePadding(padding: Int, textView: AppCompatTextView ? = null){

        val start = ivStart.drawable != null
        val end = ivEnd.drawable != null

        val defaultLeft = textView?.paddingLeft ?: 0
        val defaultRight = textView?.paddingRight ?: 0
        val top = textView?.paddingTop ?: 0
        val bottom = textView?.paddingBottom ?: 0

        val left = if (start) padding else defaultLeft
        val right = if (end) padding else defaultRight

        mText.setPadding(left, top, right, bottom)

        sText.setPadding(left, top, right, bottom)

    }

    //For XML
    private fun image(drawable : Int, image : AppCompatImageView){

        if (drawable != 0){

            image.setImageResource(drawable)
            image.visibility = View.VISIBLE

        }else{

            image.visibility = View.GONE

        }

    }

    //For XML
    private fun drawablePaddings(padding : Int, mText : AppCompatTextView, sText : AppCompatTextView, iv_start : Int, iv_end : Int){

        val left = if (iv_start != 0) padding else mText.paddingLeft
        val right = if (iv_end != 0) padding else mText.paddingRight
        val top = mText.paddingTop
        val bottom = mText.paddingBottom

        mText.setPadding(left, top, right, bottom)

        sText.setPadding(left, top, right, bottom)

    }

}// class end======================================================================