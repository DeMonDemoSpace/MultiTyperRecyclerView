package com.demon.multityperecyclerview.brvah.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseBinderAdapter
import com.demon.multityperecyclerview.data.Foot
import com.demon.multityperecyclerview.data.Header
import com.demon.multityperecyclerview.data.Student
import com.demon.multityperecyclerview.data.Teacher

/**
 * @author DeMon
 * Created on 2020/4/13.
 * E-mail 757454343@qq.com
 * Desc: 当有多种条目的时候，避免在convert()中做太多的业务逻辑，把逻辑放在对应的 ItemProvider 中。以及最大化自定义VH类型。
 *  当前多类型列表最广泛的使用方式。
 *  优点：耦合性低，每种类型都在自己的Binder里面完成；数据类型完全没有限制。
 *  缺点：每个类型都需要一个Binder&一个独自的数据类型，代码量增多。
 */
class BinderAdapter constructor(mContext: Context, list: MutableList<Any>? = null) : BaseBinderAdapter(list) {

    init {
        addItemBinder(Teacher::class.java, TeacherBinder())
        addItemBinder(Student::class.java, StudentBinder())

        /**
         *通过Binder设置头部和底部
         * 对于与数据关联的头部和底部来说，这样设置更灵活
         * 但是也额外增加了一些代码
         */
        addItemBinder(Header::class.java, HeaderBinder())
        addItemBinder(Foot::class.java, FootBinder())

        /*mContext.run {
            addHeaderView(getLayoutView(R.layout.item_header)) //添加头部视图
            addFooterView(getLayoutView(R.layout.item_foot)) //添加底部视图
        }*/
    }
}