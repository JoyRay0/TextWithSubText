package com.rk_sofwares.textwithsubtext

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

class TextWithSubText(context: Context, attrs : AttributeSet?) : LinearLayout(context, attrs) {

    private var main : AppCompatTextView
    private var sub : AppCompatTextView
    private var iv_image : AppCompatImageView

    init {

        orientation = VERTICAL
        LayoutInflater.from(context).inflate(R.layout.lay_main_sub_text, this, true)

        main = findViewById(R.id.tv_main)
        sub = findViewById(R.id.tv_sub)
        iv_image = findViewById(R.id.iv_end)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.TextWithSubText)

        val mainText = attributes.getString(R.styleable.TextWithSubText_mainText) ?: ""
        val mainTextSize = attributes.getDimension(R.styleable.TextWithSubText_mainTextSize, 15f)
        val mainTextColor = attributes.getColor(R.styleable.TextWithSubText_mainTextColor, Color.parseColor("#000000"))
        val mainTextStyle = attributes.getInt(R.styleable.TextWithSubText_mainTextStyle, 0)

        val subText = attributes.getString(R.styleable.TextWithSubText_subText) ?: ""
        val subTextSize = attributes.getDimension(R.styleable.TextWithSubText_subTextSize, 12f)
        val subTextColor = attributes.getColor(R.styleable.TextWithSubText_subTextColor, Color.parseColor("#807575"))
        val subTextStyle = attributes.getInt(R.styleable.TextWithSubText_subTextStyle, 0)

        val drawableEnd = attributes.getResourceId(R.styleable.TextWithSubText_drawableEnd, 0)
        val drawablePadding = attributes.getDimensionPixelSize(R.styleable.TextWithSubText_drawablePadding, 2)

        attributes.recycle()

        main.text = mainText
        main.textSize = mainTextSize / resources.displayMetrics.density
        main.setTextColor(mainTextColor)

        main.setTypeface(null, when(mainTextStyle) {

            1 -> Typeface.ITALIC
            2-> Typeface.BOLD
            else -> Typeface.NORMAL

        })

        sub.text = subText
        sub.textSize = subTextSize / resources.displayMetrics.density
        sub.setTextColor(subTextColor)

        sub.setTypeface(null, when(subTextStyle) {

            1 -> Typeface.ITALIC
            2-> Typeface.BOLD
            else -> Typeface.NORMAL

        })

        if (drawableEnd != 0){

            iv_image.setImageResource(drawableEnd)
            iv_image.visibility = View.VISIBLE
            iv_image.setPadding(drawablePadding, drawablePadding, drawablePadding, drawablePadding)
        }


    }

}