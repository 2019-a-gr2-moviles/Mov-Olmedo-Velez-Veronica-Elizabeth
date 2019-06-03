package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_gestionar_pokemon.*

class GestionarPokemon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestionar_pokemon)
        var pokemon: Pokemon = this.intent.getParcelableExtra<Pokemon>("Pokemon")
        actualizarDatosPokemon(pokemon)

        Log.i(
            "ACTUALIZAR-POKEMON", "${pokemon.numeroPokemon} ${pokemon.nombrePokemon} " +
                    "${pokemon.poderEspecialUno} ${pokemon.poderEspecialDos} " +
                    "${pokemon.fechaCaptura} ${pokemon.nivel} " +
                    "${pokemon.entrenadorId}"
            )


        btn_eliminar.setOnClickListener {
            pokemon.opcion = 1
            irListaPokemon(pokemon)
        }

        btn_actualizar.setOnClickListener {
            val pokemonAux = Pokemon(
                pokemon.id,
                txt_nivel.text.toString().toInt(),
                txt_numeroPokemon.text.toString(),
                txt_nombrePokemon.text.toString(),
                txt_poderEspecialUno.text.toString(),
                txt_poderEspecialDos.text.toString(),
                txt_numeroMedallas.text.toString().toInt(),
                pokemon.entrenadorId, 2
            )
            irListaPokemon(pokemonAux)
        }
    }

    fun actualizarDatosPokemon(pokemon: Pokemon) {
        txt_numeroPokemon.setText(pokemon.numeroPokemon)
        txt_nombrePokemon.setText(pokemon.nombrePokemon)
//        txt_gra_med_act.text=medicamento.gramosAIngerir.toString() as Editable
//        txt_num_pas_med_act.setText (medicamento.gramosAIngerir.toInt())
        txt_poderEspecialUno.setText(pokemon.poderEspecialUno)
         txt_poderEspecialDos.setText(pokemon.poderEspecialDos)
    }

    fun irListaPokemon(pokemon: Pokemon) {
        val intent = Intent(
            this,
            ListaPokemon::class.java
        )
        intent.putExtra("Pokemon", pokemon)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
