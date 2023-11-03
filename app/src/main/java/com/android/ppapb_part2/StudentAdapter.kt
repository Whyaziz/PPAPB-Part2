package com.android.ppapb_part2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.ppapb_part2.databinding.ItemStudentBinding

typealias OnClickStudent = (Student) -> Unit

class StudentAdapter(private val listStudent: List<Student>, private val onClickStudent: OnClickStudent) :
    RecyclerView.Adapter<StudentAdapter.ItemStudentViewHolder>() {

    inner class ItemStudentViewHolder(private val binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Student) {
            with(binding) {
                itemName.text = data.name
                itemHobby.text = data.hobby

                itemView.setOnClickListener {
                    onClickStudent(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemStudentViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemStudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    override fun onBindViewHolder(holder: ItemStudentViewHolder, position: Int) {
        holder.bind(listStudent[position])
    }
}