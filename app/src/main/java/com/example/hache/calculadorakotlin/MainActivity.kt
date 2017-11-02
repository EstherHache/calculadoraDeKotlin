package com.example.hache.calculadorakotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    var primer=0.0
    var prim = 0
    var segun=0.0
    var difer=""
    var memor=0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner= ArrayAdapter.createFromResource(this,R.array.spinner1_array,android.R.layout.simple_spinner_item)

    }
    fun numero(v : View){
        val numer=findViewById<Button>(v.id)
        val textnum=numer.text.toString()
        textView.text="${textView.text.toString()}${textnum}"
    }

    fun borrar(v : View) {
        if (textView.text.length > 0) {
            textView.text = textView.text.subSequence(0, textView.text.length - 1)
        }

    }

    fun sumar(v: View){
        try {
            primer = textView.text.toString().toDouble()
            difer = "suma"
            textView.text = ""
        }
        catch (e: Exception) {
             Toast.makeText(this, "Introduce algún número", Toast.LENGTH_SHORT).show()
        }


    }
    fun multiplicar(v: View){
        try {
            primer = textView.text.toString().toDouble()
            difer = "multi"
            textView.text = ""
        }
        catch (e: Exception) {
            Toast.makeText(this, "Introduce algún número", Toast.LENGTH_SHORT).show()
        }


    }
    fun dividir(v: View){
        try {
            primer = textView.text.toString().toDouble()
            difer = "divi"
            textView.text = ""
        }
        catch (e: Exception) {
            Toast.makeText(this, "Introduce algún número", Toast.LENGTH_SHORT).show()
        }


    }
    fun porcentaje(v: View){
        try {
            primer = textView.text.toString().toDouble()
            textView.text = (primer/100).toString()
        }
        catch (e: Exception) {
             Toast.makeText(this, "Introduce algún número", Toast.LENGTH_SHORT).show()
        }
    }
    fun decbin (v: View){
        try{
            prim= textView.text.toString().toInt()
            var binario = ""
            if(prim > 0) {
                while (prim > 0) {
                    if(prim % 2 == 0) {
                        binario = "0" + binario
                    } else {
                        binario = "1" + binario
                    }
                    prim =  prim / 2
                }
            } else if (prim == 0) {
                binario = "0"
            } else {
                Toast.makeText(this, "No se puede convertir. Ingrese solo enteros", Toast.LENGTH_SHORT).show()

            }
            textView.text = binario

        } catch (e: Exception){
            Toast.makeText(this, "No se puede convertir. Ingrese solo enteros en sistema decimal", Toast.LENGTH_SHORT).show()
        }


    }
    fun bindec (v: View) {
        try {
            var digito = 0
            var decimal = 0
            var exponente = 0
            prim = textView.text.toString().toInt()
            exponente = 0;
            decimal = 0;
            while (prim != 0) {
                digito = prim % 10;
                decimal = decimal + digito * (Math.pow(2.0, exponente.toDouble()).toInt())
                exponente++;
                prim = prim / 10;
            }
            textView.text = decimal.toString()
        }
        catch (e: Exception) {
            Toast.makeText(this, "No se puede convertir", Toast.LENGTH_SHORT).show()
        }


    }





    fun igual(v: View) {
        try {
            if(difer == "suma") {
                segun = textView.text.toString().toDouble()
                textView.text = (primer + segun).toString()
            }
            if(difer == "resta"){
                segun = textView.text.toString().toDouble()
                textView.text = (primer - segun).toString()
            }
            if(difer == "multi") {
                segun = textView.text.toString().toDouble()
                textView.text = (primer * segun).toString()
            }
            if(difer == "divi") {
                segun = textView.text.toString().toDouble()
                textView.text = (primer / segun).toString()
            }
        }
        catch (e: Exception) {
            Toast.makeText(this, "No se reconoce el formato", Toast.LENGTH_SHORT).show()
        }







    }
    fun borrarTodo(v: View){
        if (textView.text.length > 0) {
            textView.text=""
        }
    }
    fun restar(v: View){
        try {
            primer = textView.text.toString().toDouble()
            difer = "resta"
            textView.text = ""
        }
        catch (e: Exception) {
            Toast.makeText(this, "Introduce algún número", Toast.LENGTH_SHORT).show()
        }


    }
    fun memoriaPlus (v: View){
        try {
            if (textView.text.length > 0) {
                memor = memor + textView.text.toString().toDouble()
                textView.text = ""
            }
        }
        catch (e: Exception) {
            Toast.makeText(this, "Introduce algún número", Toast.LENGTH_SHORT).show()
        }

    }
    fun memoriaLess (v: View){
        try {
            if (textView.text.length > 0) {
                memor = memor - textView.text.toString().toDouble()
                textView.text = ""
            }
        }
        catch (e: Exception) {
            Toast.makeText(this, "Introduce algún número", Toast.LENGTH_SHORT).show()
        }

    }
    fun memoriaMe(v: View){
        try {
            textView.text = memor.toString()
        }
        catch (e: Exception) {
            Toast.makeText(this, "Introduce algún número", Toast.LENGTH_SHORT).show()
        }

    }
    fun memoriaMC(v: View){
        try {
            memor = 0.0
            textView.text = ""
        }
        catch (e: Exception) {
            Toast.makeText(this, "Introduce algún número", Toast.LENGTH_SHORT).show()
        }

    }
    fun binario(v: View){
        b2.isEnabled = false
        b3.isEnabled = false
        b4.isEnabled = false
        b5.isEnabled = false
        b6.isEnabled = false
        b7.isEnabled = false
        b8.isEnabled = false
        b9.isEnabled = false
        ba.isEnabled = false
        bb.isEnabled = false
        bc.isEnabled = false
        bd.isEnabled = false
        be.isEnabled = false
        bf.isEnabled = false
    }
    fun hexadecimal(v: View){
        b1.isEnabled = true
        b2.isEnabled = true
        b3.isEnabled = true
        b4.isEnabled = true
        b5.isEnabled = true
        b6.isEnabled = true
        b7.isEnabled = true
        b8.isEnabled = true
        b9.isEnabled = true
        b0.isEnabled = true
        ba.isEnabled = true
        bb.isEnabled = true
        bc.isEnabled = true
        bd.isEnabled = true
        be.isEnabled = true
        bf.isEnabled = true

    }
    fun decimal(v: View){
        b1.isEnabled = true
        b2.isEnabled = true
        b3.isEnabled = true
        b4.isEnabled = true
        b5.isEnabled = true
        b6.isEnabled = true
        b7.isEnabled = true
        b8.isEnabled = true
        b9.isEnabled = true
        b0.isEnabled = true
        ba.isEnabled = false
        bb.isEnabled = false
        bc.isEnabled = false
        bd.isEnabled = false
        be.isEnabled = false
        bf.isEnabled = false

    }
}
