package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_crear_pokemon.*


class CrearPokemon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_pokemon)

        var entrenador: Entrenador = this.intent.getParcelableExtra<Entrenador>("Entrenador")
        Log.i("Crear Entrenador", entrenador.nombresEntrenador)


        btn_Crear.setOnClickListener {
            val entrenador: Pokemon = Pokemon(
                0,
                txt_numeroPokemon.text.toString().toInt(),
                txt_nombrePokemon.text.toString(),
                txt_poderEspecialUno.text.toString(),
                txt_poderEspecialDos.text.toString(),
                fechaCaptura.text.toString(),
                txt_nivel.text.toString().toInt(),
                entrenador.id,
                0
            )
            irListaPokemon(entrenador)
        }
    }

    private fun irListaPokemon(pokemon: Pokemon) {
        val intent = Intent(
            this,
            ListaPokemon::class.java
        )
        intent.putExtra("Pokemon", pokemon)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)

    }
}
