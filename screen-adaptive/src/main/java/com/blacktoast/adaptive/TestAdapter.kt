package com.blacktoast.adaptive

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_data.view.*

/**
 * 测试Adapter
 * Created by black_toast on 2018/11/28.
 */
class TestAdapter: RecyclerView.Adapter<TestAdapter.TestHolder>() {
    override fun getItemCount(): Int {
        return 20;
    }

    override fun onBindViewHolder(holder: TestHolder, position: Int) {
        holder.bind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return TestHolder(view)
    }

    class TestHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(position: Int) = with(itemView) {
            tv_data.text = "data:${position}"
        }
    }
}