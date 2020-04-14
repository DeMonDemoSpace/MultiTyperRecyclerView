package com.demon.multityperecyclerview.custom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demon.multityperecyclerview.R
import com.demon.multityperecyclerview.custom.adapter.CustomAdapter
import com.demon.multityperecyclerview.ext.getDatas
import kotlinx.android.synthetic.main.layout_rv.*

/**
 * @author DeMon
 * Created on 2020/4/13.
 * E-mail 757454343@qq.com
 * Desc:
 */
class CustomActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_rv)
        title = "自定义"
        rv.adapter = CustomAdapter(getDatas())
    }
}
