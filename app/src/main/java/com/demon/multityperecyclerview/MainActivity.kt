package com.demon.multityperecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demon.multityperecyclerview.brvah.BRVAHActivity
import com.demon.multityperecyclerview.custom.CustomActivity
import com.demon.multityperecyclerview.ext.startActivity
import com.demon.multityperecyclerview.merge.MergeActivity
import com.demon.multityperecyclerview.multiType.MultiTypeActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1.setOnClickListener {
            startActivity(CustomActivity::class.java)
        }
        btn2.setOnClickListener {
            startActivity(BRVAHActivity::class.java)
        }
        btn3.setOnClickListener {
            startActivity(MultiTypeActivity::class.java)
        }
        btn4.setOnClickListener {
            startActivity(MergeActivity::class.java)
        }
    }
}
