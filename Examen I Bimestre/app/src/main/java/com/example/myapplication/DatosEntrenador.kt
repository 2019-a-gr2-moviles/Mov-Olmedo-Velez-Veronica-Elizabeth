package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_datos_entrenador.*


class DatosEntrenador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_entrenador)
        var entrenador: Entrenador = this.intent.getParcelableExtra<Entrenador>("Entrenador")
        colocarDatos(entrenador)
        btn_eliminarEntrenador.setOnClickListener {
            entrenador.opcion = 1
            irListaPacientes(entrenador)
        }
        btn_gestionarEntrenador.setOnClickListener {
            irListaPokemon(entrenador)
        }

        btn_crearEntrenador.setOnClickListener {
            irCrearPokemon(entrenador)
        }

        btn_actualizaEntrenador.setOnClickListener {
            val ActEntrenador = Entrenador(
                entrenador.id,
                txt_nombresEntrenador_act.text.toString(),
                txt_apellidosEntrenador_act.text.toString(),
                fechaNacimiento_act.text.toString(),
                txt_numeroMedallas_act.text.toString().toInt(),
                sw_campeonActual_act.isChecked,

                2
            )
            irListaPacientes(ActEntrenador)
        }
    }

    private fun irListaPacientes(entrenador: Entrenador) {
        val intent = Intent(
            this,
            ListaEntrenador::class.java
        )
        intent.putExtra("Entrenador", entrenador)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun colocarDatos(entrenador: Entrenador) {
        txt_nombresEntrenador_act.setText(entrenador.nombresEntrenador)
        txt_apellidosEntrenador_act.setText(entrenador.apellidosEntrenador)
        fechaNacimiento_act.setText(entrenador.fechaNacimiento)
        sw_campeonActual_act.isChecked = entrenador.campeonActual
    }

    private fun irListaPokemon(entrenador: Entrenador) {
        val intent = Intent(
            this,
            ListaPokemon::class.java
        )
        intent.putExtra("Entrenador", entrenador)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun irCrearPokemon(entrenador: Entrenador) {
        val intent = Intent(
            this,
            CrearPokemon::class.java
        )
        intent.putExtra("Entrenador", entrenador)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
