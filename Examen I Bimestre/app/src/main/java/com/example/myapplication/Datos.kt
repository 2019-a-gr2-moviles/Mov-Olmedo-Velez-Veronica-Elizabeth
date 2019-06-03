package com.example.myapplication

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

class Datos {
    companion object {
        var listaEntrenador: ArrayList<Entrenador> = listaEntrenadorInicial()
        var listaPokemon: ArrayList<Pokemon> = listaPokemonInicial()
        private var idEntrenador: Int = 0
        private var idPokemon: Int = 0
        var usuario = ""

        fun mensaje(opc: Int): String {
            return when (opc) {
                0 -> {
                    return StringBuilder().append(usuario).append(" ha insertado.").toString()
                }
                1 -> {
                    return StringBuilder().append(usuario).append(" ha eliminado.").toString()
                }
                2 -> {
                    return StringBuilder().append(usuario).append(" ha actualizado.").toString()
                }

                else -> {
                    return "nada"
                }
            }
        }

        private fun listaEntrenadorInicial(): ArrayList<Entrenador> {
            val lista = arrayListOf<Entrenador>()
            lista.add(Entrenador(idEntrenador(), "Veronica", "Olmedo", "25/07/1994", 3, false, -1))
            return lista
        }

        private fun listaPokemonInicial(): ArrayList<Pokemon> {
            val lista = arrayListOf<Pokemon>()
            lista.add(Pokemon(idPokemon(), 1, "Picachu", "Electricidad", "Golpe Electrico", "01/01/2020", 2, 1, -1))
            return lista
        }

        fun idEntrenador(): Int {
            idEntrenador++
            return (idEntrenador - 1)
        }

        fun idPokemon(): Int {
            idPokemon++
            return (idPokemon - 1)
        }
    }
}