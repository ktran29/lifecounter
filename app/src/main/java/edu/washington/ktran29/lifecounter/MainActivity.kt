package edu.washington.ktran29.lifecounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.text.TextWatcher
import android.text.Editable
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private var p1Life: TextView? = null
    private var p1Minus: Button? = null
    private var p1Minus5: Button? = null
    private var p1Plus: Button? = null
    private var p1Plus5: Button? = null
    private var p2Life: TextView? = null
    private var p2Minus: Button? = null
    private var p2Minus5: Button? = null
    private var p2Plus: Button? = null
    private var p2Plus5: Button? = null
    private var p3Life: TextView? = null
    private var p3Minus: Button? = null
    private var p3Minus5: Button? = null
    private var p3Plus: Button? = null
    private var p3Plus5: Button? = null
    private var p4Life: TextView? = null
    private var p4Minus: Button? = null
    private var p4Minus5: Button? = null
    private var p4Plus: Button? = null
    private var p4Plus5: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        p1Life = p1life
        p1Minus = p1b3
        p1Minus5 = p1b4
        p1Plus = p1b2
        p1Plus5 = p1b1

        p2Life = p2life
        p2Minus = p2b3
        p2Minus5 = p2b4
        p2Plus = p2b3
        p2Plus5 = p2b1

        p3Life = p3life
        p3Minus = p3b3
        p3Minus5 = p3b4
        p3Plus = p3b2
        p3Plus5 = p3b1

        p4Life = p4life
        p4Minus = p4b3
        p4Minus5 = p4b4
        p4Plus = p4b2
        p4Plus5 = p4b1

        var lifeArray = arrayOf(p1Life, p2Life, p3Life, p4Life)

        for (i in 0 until lifeArray.size - 1) {
            var health = lifeArray[i]
            health?.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                    if (health?.text.toString().toInt() <= 0) {
                        Toast.makeText(this@MainActivity, "Player ${i + 1} LOSES!", Toast.LENGTH_LONG).show()
                    }
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            })
        }
    }

    fun onClick(v: View) {
        Log.i(TAG, v.tag.toString())
        val tag = v.tag.toString()
        val player = tag.substring(0, 2)
        val direction = tag.substring(5)
        var value = Character.getNumericValue(tag[3])

        Log.i(TAG, "${tag[3]}")
        Log.i(TAG, "${tag[3].toInt()}")

        value = if (direction == "minus") (0 - value) else value

        when (player) {
            "p1" -> changeLife(p1Life, value)
            "p2" -> changeLife(p2Life, value)
            "p3" -> changeLife(p3Life, value)
            "p4" -> changeLife(p4Life, value)
        }
    }

    private fun changeLife(life: TextView?, value: Int) {
        val currLife = life?.text.toString().toInt()
        life?.setText("${currLife + value}")
    }


}
