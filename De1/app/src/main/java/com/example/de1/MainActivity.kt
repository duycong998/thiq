package com.example.de1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemRecyclerViewClickListenner<Student> {
    var listStudent = mutableListOf<Student>()
    val adapter : StudentAdapter by lazy { StudentAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        getData()
    }

    private fun init() {
        listStudent.add(Student(1,"https://petto.vn/wp-content/uploads/2019/02/B%E1%BB%99-%E1%BA%A3nh-m%E1%BA%AFt-m%C3%A8o-%C4%91%E1%BA%B9p-lung-linh38.jpg","A","VietNam","18C1"))
        listStudent.add(Student(2,"https://petto.vn/wp-content/uploads/2019/02/B%E1%BB%99-%E1%BA%A3nh-m%E1%BA%AFt-m%C3%A8o-%C4%91%E1%BA%B9p-lung-linh38.jpg","Hoang Thi Kieu Chinh","QuangNam","18C1"))
        listStudent.add(Student(3,"https://petto.vn/wp-content/uploads/2019/02/B%E1%BB%99-%E1%BA%A3nh-m%E1%BA%AFt-m%C3%A8o-%C4%91%E1%BA%B9p-lung-linh38.jpg","A","VietNam","18C1"))
        listStudent.add(Student(4,"https://petto.vn/wp-content/uploads/2019/02/B%E1%BB%99-%E1%BA%A3nh-m%E1%BA%AFt-m%C3%A8o-%C4%91%E1%BA%B9p-lung-linh38.jpg","A","VietNam","18C1"))
        listStudent.add(Student(5,"https://petto.vn/wp-content/uploads/2019/02/B%E1%BB%99-%E1%BA%A3nh-m%E1%BA%AFt-m%C3%A8o-%C4%91%E1%BA%B9p-lung-linh38.jpg","A","VietNam","18C1"))
        listStudent.add(Student(6,"https://petto.vn/wp-content/uploads/2019/02/B%E1%BB%99-%E1%BA%A3nh-m%E1%BA%AFt-m%C3%A8o-%C4%91%E1%BA%B9p-lung-linh38.jpg","A","VietNam","18C1"))
        listStudent.add(Student(7,"https://petto.vn/wp-content/uploads/2019/02/B%E1%BB%99-%E1%BA%A3nh-m%E1%BA%AFt-m%C3%A8o-%C4%91%E1%BA%B9p-lung-linh38.jpg","A","VietNam","18C1"))
    }

    private fun getData() {
        adapter.updateData(listStudent)
        recyclerviewMain.adapter = adapter
        adapter.registerItemRecyclerViewClickListener(this)
    }

    override fun onItemClickListener(item: Student?) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("key", item)
        startActivity(intent)
    }

    override fun onDelete(position: Int) {
        adapter.removeStudent(position)
    }

    override fun onEdit(student: Student) {
        TODO("Not yet implemented")
    }
}