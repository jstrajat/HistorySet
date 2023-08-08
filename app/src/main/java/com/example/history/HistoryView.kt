package com.example.history

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.lang.StringBuilder

class HistoryView : AppCompatActivity() {
    private lateinit var tv_expression : TextView
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_view)
        tv_expression = findViewById(R.id.text1)
        sharedPreferences  = getSharedPreferences(resources.getString(R.string.shared_preferences), MODE_PRIVATE)
    }

    override fun onStart() {
        super.onStart()

        var history = sharedPreferences.getStringSet(getString(R.string.sp_getHistory),null)
        println(history)
        var sb = StringBuilder()

        history?.let {
            for(s in it){
                sb.append("$s \n")
            }
        }
        tv_expression.text = sb
    }
}