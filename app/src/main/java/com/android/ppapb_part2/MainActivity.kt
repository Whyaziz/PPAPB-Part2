package com.android.ppapb_part2

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.ppapb_part2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: ActivityMainBinding
    private val provinceName = arrayOf(
        "Silahkan Pilih Provinsi Anda",
        "Daerah Istimewa Yogyakarta",
        "Jawa Barat",
        "Jawa Tengah",
        "Jawa Timur",
        "Nusa Tenggara Barat",
        "Nusa Tenggara Timur",
        "Bali"
    )
    private lateinit var countryName: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        countryName = resources.getStringArray(R.array.country)

        with(binding){
            val adapterProvinceName = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_spinner_dropdown_item,
                provinceName)

            adapterProvinceName.setDropDownViewResource(
                com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
            spinnerProvince.adapter = adapterProvinceName

            val adapterCityName = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_spinner_dropdown_item,
                countryName)

            adapterCityName.setDropDownViewResource(
                com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
            spinnerCity.adapter = adapterCityName


            spinnerCity.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long){

                        val country = countryName[position]
                        Toast.makeText(this@MainActivity, country, Toast.LENGTH_SHORT).show()

                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }
                }

//            calendar.init(calendar.year,calendar.month,calendar.dayOfMonth){
//                _, year, month, dayOfMonth ->
//
//                val selectedDate = "$dayOfMonth/${month+1}/$year"
//                Toast.makeText(this@MainActivity, selectedDate, Toast.LENGTH_SHORT).show()
//            }
//
//            jam.setOnTimeChangedListener{View,hourOfDay,minute ->
//
//                var selectedTime = String.format("%02d:%2d", hourOfDay, minute)
//                Toast.makeText(this@MainActivity, selectedTime, Toast.LENGTH_SHORT).show()
//            }

            btnShowCalendar.setOnClickListener {
                val calendar = DatePicker()
                calendar.show(supportFragmentManager, "Calendar")
            }

            bthShowTime.setOnClickListener {
                val timePicker = TimePicker()
                timePicker.show(supportFragmentManager,"Time")
            }


        }

    }

    override fun onDateSet(
        view: android.widget.DatePicker?,
        year: Int,
        month: Int,
        dayOfMonth: Int
    ) {
        val selectedDAte = "$dayOfMonth/${month+1}/$year"
        Toast.makeText(this@MainActivity, selectedDAte, Toast.LENGTH_SHORT).show()
    }

    override fun onTimeSet(view: android.widget.TimePicker?, hourOfDay: Int, minute: Int) {
        val selectedTime = "$hourOfDay:$minute"
        Toast.makeText(this@MainActivity, selectedTime, Toast.LENGTH_SHORT).show()
    }
}