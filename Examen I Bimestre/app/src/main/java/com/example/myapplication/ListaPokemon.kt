package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_pokemon.*

class ListaPokemon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pokemon)

        var entrenador: Entrenador? = this.intent.getParcelableExtra<Entrenador>("Entrenador")
        var pokemon: Pokemon? = this.intent.getParcelableExtra<Pokemon>("Pokemon")
        var listaPokemonFiltrada: ArrayList<Pokemon> = arrayListOf<Pokemon>()

        if (entrenador != null) {
            listaPokemonFiltrada = listaFiltrada(entrenador.id)

        } else if (pokemon != null) {
            when (pokemon.opcion) {
                0 -> {
                    pokemon.id = Datos.idPokemon()
                    Datos.listaPokemon.add(pokemon)
                }
                1 -> {
                    val listaAux =
                        Datos.listaPokemon.filter { pokemonAux -> pokemonAux.id != pokemon.id }
                    Datos.listaPokemon = listaAux as ArrayList<Pokemon>
                }
                2 -> {
                    Datos.listaPokemon.map { pokemonAux ->
                        if (pokemonAux.id == pokemon.id) {
                            pokemonAux.numeroPokemon = pokemon.numeroPokemon
                            pokemonAux.nombrePokemon = pokemon.nombrePokemon
                            pokemonAux.poderEspecialUno = pokemon.poderEspecialUno
                            pokemonAux.poderEspecialDos = pokemon.poderEspecialDos
                            pokemonAux.fechaCaptura = pokemon.fechaCaptura
                            pokemonAux.nivel = pokemon.nivel
                            pokemonAux.entrenadorId = pokemon.entrenadorId

                        }
                    }


                    Datos.listaPokemon.forEach { pokemon ->
                        Log.i(
                            "###",
                            "${pokemon.numeroPokemon} ${pokemon.nombrePokemon} ${pokemon.poderEspecialUno} ${pokemon.poderEspecialDos}${pokemon.fechaCaptura} ${pokemon.nivel}"
                        )
                    }
                }
                else -> {

                }
            }
            Log.i("idP@C", "${pokemon.entrenadorId}")
            listaPokemonFiltrada =
                Datos.listaPokemon.filter { pokemonAux -> pokemonAux.entrenadorId == pokemon.entrenadorId } as ArrayList<Pokemon>
            Snackbar
                .make(lv_pokemon, Datos.mensaje(pokemon.opcion), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPokemonFiltrada)
        lv_pokemon.adapter = adapter

        lv_pokemon.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            listaPokemonFiltrada.forEach { med -> Log.i("idP@C", "${med.entrenadorId}") }
            Log.i("ll", listaPokemonFiltrada[id.toInt()].toString())
            irGestionarPokemon(listaPokemonFiltrada[id.toInt()])
        }
    }


    private fun listaFiltrada(id: Int): ArrayList<Pokemon> {
        return Datos.listaPokemon.filter { entrenador -> entrenador.entrenadorId == id } as ArrayList<Pokemon>
    }

    private fun irGestionarPokemon(pokemon: Pokemon) {
        val intent = Intent(
            this,
            GestionarPokemon::class.java
        )

        intent.putExtra("pokemon", pokemon)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
