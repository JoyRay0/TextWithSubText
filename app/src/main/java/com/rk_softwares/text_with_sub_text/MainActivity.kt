package com.rk_softwares.text_with_sub_text

import android.graphics.Typeface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rk_softwares.textwithsubtext.TextWithSubText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextWithSubText>(R.id.text)

        text.setOnClickListener {

            Toast.makeText(this, "Hello world", Toast.LENGTH_SHORT).show()

        }

        text.setMainText("Hello")
        text.setSubText("World")
        text.setMainTextColor("#000000")
        text.setMainTextStyle(Typeface.BOLD)
        text.setSubTextColor("#000000")
        text.setMainTextSize(30)
        text.setSubTextSize(20)
        text.setSubTextStyle(Typeface.NORMAL)
        //text.drawableStart(R.drawable.ic_android)
        //text.drawableEnd(R.drawable.ic_forward_)
        text.drawablePadding(10)


    }
}