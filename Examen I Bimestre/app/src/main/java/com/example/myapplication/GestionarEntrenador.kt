package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_gestion_entrenador.*

class GestionarEntrenador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_entrenador)

        btn_gestionarEntrenador.setOnClickListener {
            irListaEntrenador()
        }

        btn_crearEntrenador.setOnClickListener {
            irCrearEntrenador()
        }

    }

    private fun irListaEntrenador() {
        val intent = Intent(
            this,
            ListaEntrenador::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun irCrearEntrenador() {
        val intent = Intent(
            this,
            CrearEntrenador::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
