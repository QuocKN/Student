package com.example.sinhvien

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

data class Student(val name: String, val mssv: String)

class StudentAdapter(private val context: Context, private val students: MutableList<Student>) : BaseAdapter() {

    override fun getCount(): Int = students.size
    override fun getItem(position: Int): Any = students[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val student = students[position]
        viewHolder.txtStudent.text = student.name
        viewHolder.txtMSSV.text = "MSSV: ${student.mssv}"

        viewHolder.btnDelete.setOnClickListener {
            students.removeAt(position)
            notifyDataSetChanged()
        }

        return view
    }

    private class ViewHolder(view: View) {
        val txtStudent: TextView = view.findViewById(R.id.txtStudent)
        val txtMSSV: TextView = view.findViewById(R.id.txtMSSV)
        val btnDelete: Button = view.findViewById(R.id.btnDelete)
    }
}
