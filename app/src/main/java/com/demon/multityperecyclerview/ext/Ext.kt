package com.demon.multityperecyclerview.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import com.demon.multityperecyclerview.data.Person
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream

/**
 * @author DeMon
 * Created on 2020/4/13.
 * E-mail 757454343@qq.com
 * Desc:
 */

fun Context.getDatas(): MutableList<Person> {
    val randomIS: InputStream = this.assets.open("data.json")
    val size = randomIS.available()
    val buffer = ByteArray(size)
    randomIS.read(buffer)
    randomIS.close()
    val str = String(buffer)
    return Gson().fromJson(str, object : TypeToken<MutableList<Person>>() {}.type)
}

fun <T> Context.startActivity(clazz: Class<T>) {
    this.startActivity(Intent(this, clazz))
}


fun Context.getLayoutView(layout: Int): View {
    return LayoutInflater.from(this).inflate(layout, null)
}
