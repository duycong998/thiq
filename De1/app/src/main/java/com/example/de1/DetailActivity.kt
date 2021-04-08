package com.example.de1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    var student: Student? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        student = intent.getParcelableExtra<Student>("key") as Student
        if (student != null) {
            Picasso.get().load(student!!.img).into(image_detail)
            text_view_name_detail.text = student!!.name
            text_view_addr_detail.text = student!!.address
            text_view_class_detail.text = student!!.myClass
        }
    }
}