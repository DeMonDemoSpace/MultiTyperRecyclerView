package com.demon.multityperecyclerview.multiType

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demon.multityperecyclerview.R
import com.demon.multityperecyclerview.data.*
import com.demon.multityperecyclerview.ext.getDatas
import com.demon.multityperecyclerview.multiType.adapter.FootItemBinder
import com.demon.multityperecyclerview.multiType.adapter.HeaderItemBinder
import com.demon.multityperecyclerview.multiType.adapter.StudentItemBinder
import com.demon.multityperecyclerview.multiType.adapter.TeacherItemBinder
import com.drakeet.multitype.MultiTypeAdapter
import kotlinx.android.synthetic.main.layout_rv.*

/**
 * @author DeMon
 * Created on 2020/4/13.
 * E-mail 757454343@qq.com
 * Desc:MultiType多类型列表的框架<https://github.com/drakeet/MultiType>
 */
class MultiTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_rv)
        title = "MultiType"

        val adapter = MultiTypeAdapter()
        with(adapter) {
            register(Teacher::class.java, TeacherItemBinder())
            register(Student::class.java, StudentItemBinder())
            register(Header::class.java, HeaderItemBinder())
            register(Foot::class.java, FootItemBinder())
        }
        val list = mutableListOf<Any>()
        list.add(Header())
        getDatas().forEach {
            when (it.itemType) {
                Person.ITEM_TEACHER -> {
                    val s = Teacher()
                    s.name = it.name
                    list.add(s)
                }
                Person.ITEM_STUDENT -> {
                    val s = Student()
                    s.name = it.name
                    list.add(s)
                }
            }
        }
        list.add(Foot())
        adapter.items = list
        rv.adapter = adapter
    }
}
