package com.demon.multityperecyclerview.brvah

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.demon.multityperecyclerview.R
import com.demon.multityperecyclerview.brvah.adapter.BinderAdapter
import com.demon.multityperecyclerview.brvah.adapter.DelegateMultiAdapter
import com.demon.multityperecyclerview.brvah.adapter.MultiItemAdapter
import com.demon.multityperecyclerview.data.*
import com.demon.multityperecyclerview.ext.getDatas
import kotlinx.android.synthetic.main.layout_rv.*

/**
 * @author DeMon
 * Created on 2020/4/13.
 * E-mail 757454343@qq.com
 * Desc:
 */
class TabFragment constructor(val type: String) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_rv, container)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        when (type) {
            "BaseMultiItemQuickAdapter" -> {
                context?.run {
                    rv.adapter = MultiItemAdapter(this, getDatas())
                }
            }
            "BaseDelegateMultiAdapter" -> {
                context?.run { rv.adapter = DelegateMultiAdapter(this, getDatas()) }
            }
            "BaseBinderAdapter" -> {
                context?.run {
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
                    rv.adapter = BinderAdapter(this, list)
                }
            }
        }
    }
}