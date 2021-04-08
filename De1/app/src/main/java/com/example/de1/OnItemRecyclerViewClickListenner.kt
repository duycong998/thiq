package com.example.de1

interface OnItemRecyclerViewClickListenner<T> {
    fun onItemClickListener(item: T?)
    fun onDelete(position: Int)
    fun onEdit(student: Student)
}