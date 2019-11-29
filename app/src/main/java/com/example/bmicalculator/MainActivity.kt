package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.time.OffsetTime

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fun calculateBMI(weight:Double, height:Double):Double{
            return weight / Math.pow(height,2.0)
        }
        buttonCalculate.setOnClickListener {
           val weight:Double = editTextWeight.text.toString().toDouble()
           val height:Double = editTextHeight.text.toString().toDouble()
           val bmi:Double = calculateBMI(weight,height)
           val status:String
           try {
               if (bmi < 18.5) {
                   imageViewProfile.setImageResource(R.drawable.under)
                   status = "Under Weight"
               } else if (bmi < 25) {
                   imageViewProfile.setImageResource(R.drawable.normal)
                   status = "Normal Weight"
               } else {
                   imageViewProfile.setImageResource(R.drawable.over)
                   status = "Over Weight"
               }
               textViewBMI.text = "BMI %.2f (%S)".format(bmi, status)
           }catch (ex:Exception){
               val toast:Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)
               toast.setGravity(Gravity.CENTER, 0, 0)
               toast.show()
           }
        }
        buttonReset.setOnClickListener {
            editTextHeight.text = null
            editTextWeight.text = null
            textViewBMI.text = "BMI:"
            imageViewProfile.setImageResource(R.drawable.empty)
        }
    }
}


