//사람 수 세기 앱
package com.example.myapplication0218

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_click_me : Button = findViewById(R.id.btn_click_me)
        val tv_people_num : TextView = findViewById(R.id.tv_people_num)
        var people_num = 0

        btn_click_me.setOnClickListener()
        {
            people_num++
            tv_people_num.text = people_num.toString()
            Toast.makeText(this, "total : ${people_num}", Toast.LENGTH_SHORT).show()

        }

    }

}
