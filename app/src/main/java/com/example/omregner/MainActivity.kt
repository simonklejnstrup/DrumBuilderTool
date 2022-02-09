package com.example.omregner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.omregner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button12.setOnClickListener(this)
        binding.button14.setOnClickListener(this)
        binding.button15.setOnClickListener(this)
        binding.button16.setOnClickListener(this)
        binding.button18.setOnClickListener(this)
        binding.button22.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val buttonPressed = v as Button

        //take the button text, slice the quotation mark, convert it to String and parse it to Int
        val diameter = Integer.parseInt(buttonPressed.text.slice(0..1).toString())

        //default all buttons colors to grey
        binding.button12.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button14.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button15.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button16.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button18.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button22.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))

        //set pressed button backgroundcolor
        buttonPressed.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.purple_200))
    }
}