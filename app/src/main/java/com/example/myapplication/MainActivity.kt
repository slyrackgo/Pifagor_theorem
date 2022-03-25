package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    //The main code
    fun onClickResult(view : View){
        if(!isFieldEmpty()) {
            val result = getString(R.string.result_info) + getResult()
                    binding.tvResult.text = result

        }
    }
    //The warning to fill required area
    private fun isFieldEmpty():Boolean {
        binding.apply{
            if(edA.text.isNullOrEmpty()) edA.error = "Fill the area please!"
            if(edB.text.isNullOrEmpty()) edB.error = "Fill the area please!"
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }
    //The square root formula
    private fun getResult(): String {
        val a: Double
        val b: Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
        return sqrt((a.pow(n = 2) + b.pow(n = 2))).toString()
    }
}   