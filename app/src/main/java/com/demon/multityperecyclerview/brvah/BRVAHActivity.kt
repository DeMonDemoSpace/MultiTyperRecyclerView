package com.demon.multityperecyclerview.brvah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.chad.library.adapter.base.BaseBinderAdapter
import com.demon.multityperecyclerview.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_brvah.*
/**
 * @author DeMon
 * Created on 2020/4/13.
 * E-mail 757454343@qq.com
 * Desc:BRVAH三种多类型的不同实现
 * 详情见:<https://github.com/CymChad/BaseRecyclerViewAdapterHelper/blob/master/readme/4-%E5%A4%9A%E5%B8%83%E5%B1%80.md>
 */
class BRVAHActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brvah)
        title = "BRVAH"

        val list = arrayListOf("BaseMultiItemQuickAdapter", "BaseDelegateMultiAdapter", "BaseBinderAdapter")

        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = list.size

            override fun createFragment(position: Int): Fragment = TabFragment(list[position])
        }
        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = list[position]
        }.attach()
    }
}
