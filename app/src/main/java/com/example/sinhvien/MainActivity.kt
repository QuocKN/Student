package com.example.sinhvien

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inputHoten: EditText
    private lateinit var inputMSSV: EditText
    private lateinit var buttonAdd: Button
    private lateinit var listView: ListView
    private lateinit var studentAdapter: StudentAdapter
    private val studentList = mutableListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        inputHoten = findViewById(R.id.inputHoten)
        inputMSSV = findViewById(R.id.inputMSSV)
        buttonAdd = findViewById<Button>(R.id.buttonAdd)
        listView = findViewById<ListView>(R.id.list_students)

        inputHoten.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && inputHoten.text.toString() == "Họ và tên") {
                inputHoten.setText("")
            }
        }
        inputMSSV.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && inputMSSV.text.toString() == "MSSV") {
                inputMSSV.setText("")
            }
        }

        studentAdapter = StudentAdapter(this, studentList)
        listView.adapter = studentAdapter

        buttonAdd.setOnClickListener {
            val name = inputHoten.text.toString()
            val mssv = inputMSSV.text.toString()

            if (name.isNotEmpty() && mssv.isNotEmpty()) {
                studentList.add(Student(name, mssv))
                studentAdapter.notifyDataSetChanged()
                inputHoten.text.clear()
                inputMSSV.text.clear()
            }
        }

    }
}