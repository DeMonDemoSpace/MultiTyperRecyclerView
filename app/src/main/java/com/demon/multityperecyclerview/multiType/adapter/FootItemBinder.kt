package com.demon.multityperecyclerview.multiType.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.demon.multityperecyclerview.R
import com.demon.multityperecyclerview.adapter.ViewHolder
import com.demon.multityperecyclerview.data.Foot
import com.drakeet.multitype.ItemViewBinder

/**
 * @author DeMon
 * Created on 2020/4/13.
 * E-mail 757454343@qq.com
 * Desc:
 */
class FootItemBinder : ItemViewBinder<Foot, ViewHolder>() {



    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_foot, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: Foot) {

    }
}