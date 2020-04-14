package com.demon.multityperecyclerview.brvah.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
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
 * Desc: BRVAH的BaseMultiItemQuickAdapter实现
 * 适用于类型较少，业务不复杂的场景，便于快速使用。
 * 优点: 封装的较为严密，头部和底部视图可直接添加，无需额外添加itemViewType。
 * 缺点：数据类必须实现MultiItemEntity，数据类不够灵活。
 */
class MultiItemAdapter(mContext: Context, data: MutableList<Person>?) : BaseMultiItemQuickAdapter<Person, ViewHolder>(data) {

    init {
        addItemType(Person.ITEM_TEACHER, R.layout.item_teacher)
        addItemType(Person.ITEM_STUDENT, R.layout.item_student)
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