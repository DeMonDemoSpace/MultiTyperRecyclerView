package com.demon.multityperecyclerview.brvah.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseDelegateMultiAdapter
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate
import com.demon.multityperecyclerview.R
import com.demon.multityperecyclerview.adapter.ViewHolder
import com.demon.multityperecyclerview.data.Person
import com.demon.multityperecyclerview.ext.getLayoutView
import kotlinx.android.synthetic.main.item_student.*
import kotlinx.android.synthetic.main.item_teacher.*

/**
 * @author DeMon
 * Created on 2020/4/13.
 * E-mail 757454343@qq.com
 * Desc: 通过代理类的方式，返回布局 id 和 item 类型；适用于数据类不方便扩展的情况。
 *  本质上与BaseMultiItemQuickAdapter相同，只是将获取itemType的方式改为了代理实现。
 *   优点：降低了对数据类的要求，使用更灵活。
 *   缺点：增加了Adapter的负担，使得该类不易扩展。
 */
class DelegateMultiAdapter(mContext: Context, data: MutableList<Person>?) : BaseDelegateMultiAdapter<Person, ViewHolder>(data) {

    init {
        // 第一步，设置代理
        setMultiTypeDelegate(object : BaseMultiTypeDelegate<Person>() {
            override fun getItemType(data: List<Person>, position: Int): Int {
                return if (data[position].name.contains("老师")) {
                    Person.ITEM_TEACHER
                } else {
                    Person.ITEM_STUDENT
                }
            }
        })
        // 第二部，绑定 item 类型
        getMultiTypeDelegate()?.run {
            addItemType(Person.ITEM_TEACHER, R.layout.item_teacher)
            addItemType(Person.ITEM_STUDENT, R.layout.item_student)
        }
        mContext.run {
            addHeaderView(getLayoutView(R.layout.item_header)) //添加头部视图
            addFooterView(getLayoutView(R.layout.item_foot)) //添加底部视图
        }
    }

    override fun convert(holder: ViewHolder, item: Person) {
        when (holder.itemViewType) {
            Person.ITEM_STUDENT -> {
                holder.tvStudent.text = item.name
            }
            Person.ITEM_TEACHER -> {
                holder.tvTeacher.text = item.name
            }
        }
    }
}