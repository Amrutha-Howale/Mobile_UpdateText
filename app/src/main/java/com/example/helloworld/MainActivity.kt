package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

/*fun <K> increment(map: MutableMap<K, Int?>, key: K) {
    val value = if (map.containsKey(key)) map[key] else 0
    map[key] = value!! + 1
}*/

class MainActivity : AppCompatActivity() {

    var clickCount=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ClickCountDisplayView = findViewById<TextView>(R.id.ClickCountView)
        val clickMeButton = findViewById<TextView>(R.id.ClickButton)
        val UserNameTextInputView=findViewById<TextInputLayout>(R.id.nameText)

        val mapvalue = mutableMapOf("somebody" to 0 )

        var count =0

        clickMeButton.setOnClickListener {
            var userName =  UserNameTextInputView.editText?.text.toString()
            if(userName.isNullOrEmpty()){
                userName = "somebody"
            }
            if(!mapvalue.containsKey(userName)){
                mapvalue.put(userName, 1)
            }
            else{

                count = mapvalue[userName]!!
                count++
                mapvalue[userName]=count

            }
            count = mapvalue[userName]!!

            ClickCountDisplayView.text = "$userName Clicked $count times"

        }
    }
}