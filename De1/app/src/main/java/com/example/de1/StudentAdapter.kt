package com.example.de1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.item_view_student.view.*

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    private val listStudent = mutableListOf<Student>()
    private var onItemClickListener: OnItemRecyclerViewClickListenner<Student>? = null

    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListenner<Student>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    fun updateData(students: MutableList<Student>) {
        students?.let {
            this.listStudent.clear()
            this.listStudent.addAll(students)
            notifyDataSetChanged()
        }
    }

    fun removeStudent(position: Int) {
       notifyItemRemoved(position)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        fun onBind(student: Student) {
            itemView.run {
                Picasso.get().load(student.img).into(image)
                text_view_name.text = student.name
                text_view_addr.text = student.address
                text_view_class.text = student.myClass

            }
            itemView.image_delete.setOnClickListener {
                onItemClickListener!!.onDelete(
                    adapterPosition
                )
            }
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onItemClickListener?.onItemClickListener(listStudent[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_student, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listStudent[position])
    }

    override fun getItemCount(): Int = listStudent.size
}