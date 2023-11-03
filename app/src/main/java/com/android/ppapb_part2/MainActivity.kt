package com.android.ppapb_part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.ppapb_part2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var adapterStudent = StudentAdapter(generateStudentsData()) {
                student ->
            Toast.makeText(this@MainActivity, "You clicked on ${student.name}", Toast.LENGTH_SHORT).show()
        }
        with(binding) {
            rycItemKiri.apply {
                adapter = adapterStudent
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
    fun generateStudentsData() : List<Student> {
        return listOf(
            Student(name = "Rambu", hobby = "Memancing"),
            Student(name = "Aziz", hobby = "Mbego"),
            Student(name = "Darel", hobby = "Ngopi"),
            Student(name = "Wildan", hobby = "Putus Nyambung"),
            Student(name = "Yodhim", hobby = "Nebeng")
        )
    }
}