package com.demon.multityperecyclerview.multiType.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.demon.multityperecyclerview.R
import com.demon.multityperecyclerview.adapter.ViewHolder
import com.demon.multityperecyclerview.data.Teacher
import com.drakeet.multitype.ItemViewBinder
import kotlinx.android.synthetic.main.item_teacher.*

/**
 * @author DeMon
 * Created on 2020/4/13.
 * E-mail 757454343@qq.com
 * Desc:
 */
class TeacherItemBinder :ItemViewBinder<Teacher, ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, item: Teacher) {
        holder.tvTeacher.text = item.name
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_teacher, parent, false))
    }
}