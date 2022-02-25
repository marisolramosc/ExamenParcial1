package com.example.examenparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var resultado: TextView? = null

    private lateinit var Input1: EditText
    private lateinit var Input2: EditText
    private lateinit var Input3: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val Input1: EditText = findViewById<EditText>(R.id.Input1)
//        val Input2: EditText = findViewById<EditText>(R.id.Input2)
//        val Input3: EditText = findViewById<EditText>(R.id.Input3)
        val limpiar: Button = findViewById<Button>(R.id.limpiar)
        val agregar: Button = findViewById<Button>(R.id.agregar)

        resultado = findViewById<TextView>(R.id.Resultado)
        Input1 = findViewById<EditText>(R.id.Input1)
        Input2 = findViewById<EditText>(R.id.Input2)
        Input3 = findViewById<EditText>(R.id.Input3)

//        resultado?.text = ""
        resultado?.movementMethod = ScrollingMovementMethod()

        agregar?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                if(Input1.text.toString() != "" && Input2.text.toString() != "" && Input3.text.toString() != "") {
                    resultado?.append(Input1.text)
                    resultado?.append(" + ")
                    resultado?.append(Input2.text)
                    resultado?.append(" = ")
                    resultado?.append(Input3.text)
                    resultado?.append("\n")
                    Input1.setText("")
                    Input1.text.clear()
                    Input2.setText("")
                    Input2.text.clear()
                    Input3.setText("")
                    Input3.text.clear()
                }
            }
        })

        limpiar?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Input1.text.clear()
                Input2.text.clear()
                Input3.text.clear()
                resultado?.text = ("")
            }
        })
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        resultado?.text = savedInstanceState.getString("resultado")
//        Input1.append(savedInstanceState.getString("Input1"))
//        Input2.append(savedInstanceState.getString("Input2"))
//        Input3.append(savedInstanceState.getString("Input3"))
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("resultado", resultado?.text.toString())
//        outState.putString("Input1", Input1?.text.toString())
//        outState.putString("Input2", Input2?.text.toString())
//        outState.putString("Input3", Input3?.text.toString())
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}