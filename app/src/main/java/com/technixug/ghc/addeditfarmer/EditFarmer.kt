package com.technixug.ghc.addeditfarmer

import android.os.Bundle
import android.telecom.Call
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.technixug.ghc.DatePickerHelper
import com.technixug.ghc.R
import okhttp3.ResponseBody
import retrofit2.Response
import java.util.*


class EditFarmer : AppCompatActivity() {


    private lateinit var datePicker: DatePickerHelper

//http://196.43.152.10/COOPERP/Mobile/Default.aspx?
    // DataFormat=NewFarmer
    // &FName=mulyazawo
    // &SName=Rashid
    // &Sex=male
    // &DOB=2021-01-01
    // &maritalS=married
    // &Feduc=certificate
    // &district=kampala
    // &county=Kyadondo
    // &subcounty=Kira
    // &village=kireka
    // &group=1
    // &comment=-
    // &enteredby=Hamm
    // &photo=5222
    // &phone=0701624476

    //TODO declare fields here

    private var dataformat: String = "NewFarmer"
    private var etFirstName: EditText? = null
    private var etOtherName: EditText? = null
    private var etSex: EditText?= null
    private var etDOB: EditText?= null
    private var etMStatus: EditText?= null
    private var etEduc: EditText?= null
    private var etDistrict: EditText?= null
    private var etCounty: EditText?= null
    private var etSubCounty: EditText?= null
    private var etVillage: EditText?= null
    private var etGroup: EditText?= null
    private var etComment: EditText?= null
    private var etEnteredBy: EditText?= null
    private var etPhoto: Int?= null
    private var etPhone: EditText?= null

    private var btnSubmit: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_farmer)
        // title= TODO()

        ///date picker
        val buttonSelectDate = findViewById<Button>(R.id.btSelectDate)
        datePicker = DatePickerHelper(this)
        buttonSelectDate.setOnClickListener {
            showDatePickerDialog()
        }
        //date picker

        //initalise by connecting decalred varible with xml resource
        etFirstName = findViewById(R.id.et_firstname);
        etOtherName = findViewById(R.id.et_othername);


        btnSubmit = findViewById<View>(R.id.btn_add_farmer) as Button
        btnSubmit!!.setOnClickListener {

            insertData()
        }
    }

    private fun showDatePickerDialog() {
        val cal = Calendar.getInstance()
        val d = cal.get(Calendar.DAY_OF_MONTH)
        val m = cal.get(Calendar.MONTH)
        val y = cal.get(Calendar.YEAR)

        val tvDate = findViewById<TextView>(R.id.tvDate)

        datePicker.showDialog(d, m, y, object : DatePickerHelper.Callback {
            override fun onDateSelected(dayofMonth: Int, month: Int, year: Int) {
                val dayStr = if (dayofMonth < 10) "0${dayofMonth}" else "${dayofMonth}"
                val mon = month + 1
                val monthStr = if (mon < 10) "0${mon}" else "$mon"
                tvDate.text = "${dayStr}-${monthStr}-${year}"
            }
        })
    }

    private fun insertData() {
        val name: String = etFirstName?.text.toString().trim()
        val email: String = etOtherName?.text.toString().trim()

        if (name.isEmpty()) {
            etFirstName?.error = "Enter name"
            etFirstName?.requestFocus()
            return
        }
        if (email.isEmpty()) {
            etOtherName?.error = "enter email"
            etOtherName?.requestFocus()
            return
        }

//        val call: Call<ResponseBody> = MyClient.getInstance().getMyApi().insertdata(name, email)
//        call.enqueue(object : DatePickerHelper.Callback<ResponseBody?>() {
//            fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>?) {}
//            fun onFailure(call: Call<ResponseBody?>?, t: Throwable?) {}
//        })

        var call: Call? = MyClient.instance?.myApi?.insertdata(name,email)


            fun onResponse(call: Call, response: Response<ResponseBody?>?) {
                Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()

            }
            fun onFailure(call: Call, t: Throwable?) {

                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()

            }
    }
}




