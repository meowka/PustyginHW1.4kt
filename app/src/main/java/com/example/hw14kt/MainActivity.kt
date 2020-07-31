package com.example.hw14kt

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var btnClick: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val post = Post("20.07.2020", "homework", "my first post", 0, 25, 5)
        val post1 = PostLocation(
            "20.07.2020",
            "homework",
            "my first post",
            0,
            25,
            5,
            "nsk",
            location = 54.9700 to 82.809325
        )
        val (lat, lon) = post1.location
        dateTxt.text = post.date
        titleTxt.text = post.title
        locationTxt.text = post1.address
        contentTxt.text = post.content
        likeTxt.text = post.like.toString()
        imgBtnLocation.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("geo:$lat,$lon")
            }
            startActivity(intent)
        }
        if (post.like == 0) {
            likeTxt.text = ""
        }
        imgBtnLike.setOnClickListener {
            if (!btnClick) {
                btnClick = true
                post.like++
                likeTxt.text = post.like.toString()
                likeTxt.setTextColor(Color.parseColor("#DA0F0F"))
                imgBtnLike.setColorFilter(Color.parseColor("#DA0F0F"))
            } else if (btnClick) {
                btnClick = false
                post.like--
                if (post.like == 0) {
                    likeTxt.text = ""
                } else {
                    likeTxt.text = post.like.toString()
                }
                likeTxt.setTextColor(Color.parseColor("#FF555A5A"))
                imgBtnLike.setColorFilter(Color.parseColor("#FF555A5A"))
            }
        }
        if (post.comment != 0) {
            commentTxt.text = post.comment.toString()
        }
        if (post.share != 0) {
            shareTxt.text = post.share.toString()
        }
    }

}
