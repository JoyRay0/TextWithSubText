package com.rk_sofwares.textwithsubtext

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
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

        image(drawableStart, ivStart, drawablePadding.toInt())
        image(drawableEnd, ivEnd, drawablePadding.toInt())

        drawablePaddings(drawablePadding, mText, sText, drawableStart, 0)
        drawablePaddings(drawablePadding, mText, sText, 0, drawableEnd)

    }

    fun setMainText(text : String){

        mText.text = text

    }

    fun setMainTextSize(textSize : Int){

        mText.textSize = textSize.toFloat()

    }

    fun setMainTextColor(colorString : String ){

        try {

            mText.setTextColor(colorString.toColorInt())

        }catch (e : Exception){

            e.printStackTrace()

        }

    }

    fun setSubText(text : String){

        sText.text = text

    }

    fun setSubTextSize(textSize : Int){

        sText.textSize = textSize.toFloat()

    }

    fun setSubTextColor(colorString : String){

        try {

            sText.setTextColor(colorString.toColorInt())

        }catch (e : Exception){

            e.printStackTrace()

        }

    }

    private fun image(drawable : Int, image : AppCompatImageView, padding : Int){

        if (drawable != 0){

            image.setImageResource(drawable)
            image.visibility = View.VISIBLE

        }else{

            image.visibility = View.GONE

        }

    }

    private fun drawablePaddings(padding : Int, mText : AppCompatTextView, sText : AppCompatTextView, iv_start : Int, iv_end : Int){

        val left = if (iv_start != 0) padding else mText.paddingLeft
        val right = if (iv_end != 0) padding else mText.paddingRight
        val top = mText.paddingTop
        val bottom = mText.paddingBottom

        mText.setPadding(left, top, right, bottom)

        sText.setPadding(left, top, right, bottom)

    }

}