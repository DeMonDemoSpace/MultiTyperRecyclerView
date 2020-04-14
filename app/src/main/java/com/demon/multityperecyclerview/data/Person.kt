package com.demon.multityperecyclerview.data

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * @author DeMon
 * Created on 2020/4/13.
 * E-mail 757454343@qq.com
 * Desc:
 */
open class Person : MultiItemEntity {

    companion object {
        val ITEM_HEADER = 0
        val ITEM_TEACHER = 1
        val ITEM_STUDENT = 2
        val ITEM_FOOT = 3
    }

    var name: String = ""


    /* override fun getItemType(): Int {
         return if (name.contains("老师")) {
             ITEM_TEACHER
         } else {
             ITEM_STUDENT
         }
     }*/

    override val itemType: Int
        get() = if (name.contains("老师")) {
            ITEM_TEACHER
        } else {
            ITEM_STUDENT
        }

}

class Teacher : Person()


class Student : Person()

class Header

class Foot
