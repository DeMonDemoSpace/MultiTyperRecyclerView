package com.demon.multityperecyclerview.merge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.MergeAdapter
import com.demon.multityperecyclerview.R
import com.demon.multityperecyclerview.ext.getDatas
import com.demon.multityperecyclerview.merge.adapter.FootAdapter
import com.demon.multityperecyclerview.merge.adapter.HeaderAdapter
import com.demon.multityperecyclerview.merge.adapter.StudentAdapter
import com.demon.multityperecyclerview.merge.adapter.TeacherAdapter
import kotlinx.android.synthetic.main.layout_rv.*
/**
 * @author DeMon
 * Created on 2020/4/13.
 * E-mail 757454343@qq.com
 * Desc: 官方简单的合并Adapter，主要是为了业务解耦。<https://mp.weixin.qq.com/s/DKca6jN-KX4fxzduTqeb6w>
 * 优点: 大大降低代码耦合，单一职责原则。对于简单多类型的列表业务拆解非常适用。极大的简化了头部，顶部视图的添加。
 * 缺点: 列表展示的顺序局限性较大；无法处理不确定性的，动态类型的复杂视图。
 */
class MergeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_rv)
        title = "MergeAdapter"

        val teacherAdapter = TeacherAdapter(getDatas().filter { it.name.contains("老师") })
        val studentAdapter = StudentAdapter(getDatas().filter { !it.name.contains("老师") })
        val mergeAdapter = MergeAdapter(HeaderAdapter(), teacherAdapter, studentAdapter, FootAdapter())
        rv.adapter = mergeAdapter
    }
}
