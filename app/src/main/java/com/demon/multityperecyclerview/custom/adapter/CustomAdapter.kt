package com.demon.multityperecyclerview.custom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demon.multityperecyclerview.R
import com.demon.multityperecyclerview.adapter.ViewHolder
import com.demon.multityperecyclerview.data.Person
import kotlinx.android.synthetic.main.item_student.*
import kotlinx.android.synthetic.main.item_teacher.*

/**
 * @author DeMon
 * Created on 2020/4/13.
 * E-mail 757454343@qq.com
 * Desc: 完全自定义实现多类型列表，本质上所有的多类型列表都是这个原理实现的。
 * 适用于数据和业务不复杂，且项目内使用场景较少的情况
 * 优点：扩展性高，可随意定制。
 * 缺点：耦合性较高，业务扩展较麻烦。
 */
class CustomAdapter(private val datas: MutableList<Person>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            Person.ITEM_HEADER -> {
                ViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
                )
            }
            Person.ITEM_FOOT -> {
                ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_foot, parent, false))
            }
            Person.ITEM_STUDENT -> {
                ViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
                )
            }
            else -> {
                ViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_teacher, parent, false)
                )
            }
        }
    }

    override fun getItemCount(): Int = datas.size + 2 //+2。为了显示头部和底部


    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> {
                Person.ITEM_HEADER
            }
            datas.size + 1 -> {
                Person.ITEM_FOOT
            }
            else -> {
                datas[position - 1].itemType
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder.itemViewType) {
            Person.ITEM_STUDENT -> {
                holder.tvStudent.text = datas[position - 1].name
            }
            Person.ITEM_TEACHER -> {
                holder.tvTeacher.text = datas[position - 1].name
            }
        }
    }
}