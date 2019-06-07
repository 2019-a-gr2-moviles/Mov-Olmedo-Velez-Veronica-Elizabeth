package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import kotlinx.android.synthetic.main.activity_crear_entrenador.*
import kotlinx.android.synthetic.main.activity_crear_entrenador.sw_campeonActual_act
import kotlinx.android.synthetic.main.activity_datos_entrenador.*

class CrearEntrenador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_entrenador)
        btn_ins_pac.setOnClickListener {

            irListaEntrenador(
                txt_nombreEntrenador.text,
                txt_nombrePokemon.text,
                dp_fechaNacimiento.text,
                txt_numeroMedallas.text,
                sw_campeonActual_act.isChecked
            )

        }
    }

    public fun irListaEntrenador(
        nombresEntrenador: Editable,
        apellidosEntrenador: Editable,
        fechaNacimiento: Editable,
        numeroMedallas: Editable,
        campeonActual: Boolean
    ) {


        val intent = Intent(
            this,
            ListaEntrenador::class.java
        )

        val entrenador= Entrenador(
            0,
            nombresEntrenador.toString(),
            apellidosEntrenador.toString(),
            fechaNacimiento.toString(),
            numeroMedallas.toString().toInt(),
            campeonActual, 0
        )

        intent.putExtra("Entrenador", entrenador)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
