package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Prueba : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba)
        var entrenador: Entrenador = this.intent.getParcelableExtra<Entrenador>("Entrenador")
        Log.i("Crear Entrenador", entrenador.nombresEntrenador)
    }
}
