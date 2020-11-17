package com.nadyaka.calculator


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nadyaka.calculator.databinding.ActivityMainBinding
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
    private val ADDITION = '+'
    private val SUBTRACTION = '-'
    private val MULTIPLICATION = '*'
    private val DIVISION = '/'

    private var CURRENT_ACTION = 0.toChar()

    private var valueOne = Double.NaN
    private var valueTwo = 0.0

    private var decimalFormat = DecimalFormat("#.##########")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main);=

        binding.btnDot.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                binding.etEditText.setText(binding.etEditText.getText().toString() + ".")
            }
        })
        binding.btn0.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                binding.etEditText.setText(binding.etEditText.getText().toString() + "0")
            }
        })
        binding.btn1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                binding.etEditText.setText(binding.etEditText.getText().toString() + "1")
            }
        })
        binding.btn2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                binding.etEditText.setText(binding.etEditText.getText().toString() + "2")
            }
        })
        binding.btn3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                binding.etEditText.setText(binding.etEditText.getText().toString() + "3")
            }
        })
        binding.btn4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                binding.etEditText.setText(binding.etEditText.getText().toString() + "4")
            }
        })
        binding.btn5.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                binding.etEditText.setText(binding.etEditText.getText().toString() + "5")
            }
        })
        binding.btn6.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                binding.etEditText.setText(binding.etEditText.getText().toString() + "6")
            }
        })
        binding.btn7.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                binding.etEditText.setText(binding.etEditText.getText().toString() + "7")
            }
        })
        binding.btn8.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                binding.etEditText.setText(binding.etEditText.getText().toString() + "8")
            }
        })
        binding.btn9.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                binding.etEditText.setText(binding.etEditText.getText().toString() + "9")
            }
        })
        binding.btnAdd.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                computeCalculation()
                CURRENT_ACTION = ADDITION
                binding.tvInfo.setText(decimalFormat.format(valueOne).toString() + "+")
                binding.etEditText.setText(null)
            }
        })
        binding.btnMinus.setOnClickListener(object : View.OnClickListener {
            override  fun onClick(view: View?) {
                computeCalculation()
                CURRENT_ACTION = SUBTRACTION
                binding.tvInfo.setText(decimalFormat.format(valueOne).toString() + "-")
                binding.etEditText.setText(null)
            }
        })
        binding.btnUmn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                computeCalculation()
                CURRENT_ACTION = MULTIPLICATION
                binding.tvInfo.setText(decimalFormat.format(valueOne).toString() + "*")
                binding.etEditText.setText(null)
            }
        })
        binding.btnDel.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                computeCalculation()
                CURRENT_ACTION = DIVISION
                binding.tvInfo.setText(decimalFormat.format(valueOne).toString() + "/")
                binding.etEditText.setText(null)
            }
        })
        binding.btnItogo.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                computeCalculation()
                binding.tvInfo.setText(
                    binding.tvInfo.getText().toString() +
                            decimalFormat.format(valueTwo)
                                .toString() + " = " + decimalFormat.format(valueOne)
                )
                valueOne = Double.NaN
                CURRENT_ACTION = '0'
            }
        })
        binding.btnClear.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                if (binding.etEditText.getText().length > 0) {
                    val currentText: CharSequence = binding.etEditText.getText()
                    binding.etEditText.setText(currentText.subSequence(0, currentText.length - 1))
                } else {
                    valueOne = Double.NaN
                    valueTwo = Double.NaN
                    binding.etEditText.setText("")
                    binding.tvInfo.setText("")
                }
            }
        })
    }

    private fun computeCalculation() {
        if (!java.lang.Double.isNaN(valueOne)) {
            valueTwo = binding.etEditText.getText().toString().toDouble()
            binding.etEditText.setText(null)
            if (CURRENT_ACTION == ADDITION) valueOne =
                valueOne + valueTwo else if (CURRENT_ACTION == SUBTRACTION) valueOne =
                valueOne - valueTwo else if (CURRENT_ACTION == MULTIPLICATION) valueOne =
                valueOne * valueTwo else if (CURRENT_ACTION == DIVISION) valueOne =
                valueOne / valueTwo
        } else {
            try {
                valueOne = binding.etEditText.getText().toString().toDouble()
            } catch (e: Exception) {
            }
        }
    }
}