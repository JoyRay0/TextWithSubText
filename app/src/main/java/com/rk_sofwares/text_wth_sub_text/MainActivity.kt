package com.rk_sofwares.text_wth_sub_text

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rk_sofwares.textwithsubtext.TextWithSubText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextWithSubText>(R.id.text)

        text.setOnClickListener {

            Toast.makeText(this, "Hello world", Toast.LENGTH_SHORT).show()

        }

    }
}