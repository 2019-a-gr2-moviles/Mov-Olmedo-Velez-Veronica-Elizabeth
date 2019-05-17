package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_actividad__dos.*

class Actividad_Dos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad__dos)


        btn_actividad_uno.setOnClickListener{
            irAActividadUno()
        }
    }


    fun irAActividadUno(){

        val intent = Intent(
            this,
            Actividad_Dos::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("nombre", "Nika")
        intent.putExtra("edad",29)
        startActivity(intent)

    }
}