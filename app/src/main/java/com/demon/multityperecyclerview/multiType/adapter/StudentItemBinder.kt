package com.demon.multityperecyclerview.multiType.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.demon.multityperecyclerview.R
import com.demon.multityperecyclerview.adapter.ViewHolder
import com.demon.multityperecyclerview.data.Student
import com.drakeet.multitype.ItemViewBinder
import kotlinx.android.synthetic.main.item_student.*

/**
 * @author DeMon
 * Created on 2020/4/13.
 * E-mail 757454343@qq.com
 * Desc:
 */
class StudentItemBinder : ItemViewBinder<Student, ViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: Student) {
        holder.tvStudent.text = item.name
    }
}