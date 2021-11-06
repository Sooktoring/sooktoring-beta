package com.example.sooktoring.Message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.sooktoring.R
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList

class ChatAdapter(var messageItems: ArrayList<MessageItem?>, layoutInflater: LayoutInflater) :
    BaseAdapter() {
    var layoutInflater: LayoutInflater
    val count: () -> Int
        get() = {messageItems.size}

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): MessageItem? {
        return messageItems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View, viewGroup: ViewGroup): View? {

        //현재 보여줄 번째의(position)의 데이터로 뷰를 생성
        val item = messageItems[position]

        //재활용할 뷰는 사용하지 않음!!
        var itemView: View? = null

        //메세지가 내 메세지인지??
        itemView = if (item?.name == G.nickName) {
            layoutInflater.inflate(R.layout.my_chatbox, viewGroup, false)
        } else {
            layoutInflater.inflate(R.layout.other_chatbox, viewGroup, false)
        }

        //만들어진 itemView에 값들 설정
        val iv: CircleImageView = itemView.findViewById(R.id.iv)
        val tvName: TextView = itemView.findViewById<TextView>(R.id.tv_name)
        val tvMsg: TextView = itemView.findViewById<TextView>(R.id.tv_msg)
        val tvTime: TextView = itemView.findViewById<TextView>(R.id.tv_time)
        tvName.setText(item?.name)
        tvMsg.setText(item?.message)
        tvTime.setText(item?.time)
        itemView?.let { Glide.with(it).load(item?.pofileUrl).into(iv) }
        return itemView
    }

    init {
        this.layoutInflater = layoutInflater
    }
}