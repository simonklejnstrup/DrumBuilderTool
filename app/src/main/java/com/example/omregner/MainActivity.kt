package com.example.omregner

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.omregner.databinding.ActivityMainBinding
import kotlin.math.PI
import kotlin.math.pow

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button8.setOnClickListener(this)
        binding.button10.setOnClickListener(this)
        binding.button12.setOnClickListener(this)
        binding.button13.setOnClickListener(this)
        binding.button14.setOnClickListener(this)
        binding.button15.setOnClickListener(this)
        binding.button16.setOnClickListener(this)
        binding.button18.setOnClickListener(this)
        binding.button20.setOnClickListener(this)
        binding.button22.setOnClickListener(this)
        binding.button24.setOnClickListener(this)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }

    override fun onClick(v: View?) {
        val buttonPressed = v as Button

        //take the button text, get rid of the quotation mark, parse it to Double
        val diameter = buttonPressed.text.replace("[^0-9]".toRegex(), "").toDouble()



        //default all buttons colors to grey
        binding.button8.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button10.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button12.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button13.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button14.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button15.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button16.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button18.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button20.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button22.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))
        binding.button24.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.grey))

        //set pressed button backgroundcolor
        buttonPressed.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.purple_200))

        //set text of  tv_circumference_display
        binding.tvCircumferenceDisplay.text = getCircumferenceInCmToString(diameter)

        // set text of tv_area_display
        binding.tvAreaDisplay.text = getAreaInCmToString(diameter)

        // set text of tv_diameter_in_cm_display
        binding.tvDiameterInCmDisplay.text = (diameter * 2.54).toString()


    }

    private fun getCircumferenceInCmToString(diameter: Double): String {
        var result = (2 * PI * (diameter/2)) * 2.54
        return String.format("%.2f", result)
    }

    private fun getAreaInCmToString(diameter: Double): String {
        var diameterInCm = diameter * 2.54
        var result = PI * (diameterInCm/2).pow(2)
        return String.format("%.2f", result)
    }


}