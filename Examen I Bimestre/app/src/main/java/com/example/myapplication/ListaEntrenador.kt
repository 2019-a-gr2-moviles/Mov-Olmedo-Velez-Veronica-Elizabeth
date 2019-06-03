package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_entrenador.*

class ListaEntrenador : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_entrenador)

        var entrenador: Entrenador? = this.intent.getParcelableExtra<Entrenador>("Entrenador")
        if (entrenador != null) {
            when (entrenador.opcion) {
                0 -> {
                    entrenador.id = Datos.idEntrenador()
                    Datos.listaEntrenador.add(entrenador)

                }
                1 -> {
                    val listaPacientesAux = Datos.listaEntrenador.filter { entrenadorAux ->
                        entrenadorAux.id != entrenador.id
                    }
                    Datos.listaEntrenador = listaPacientesAux as ArrayList<Entrenador>
                }
                2 -> {
                    Datos.listaEntrenador.map { pacAux ->
                        if (pacAux.id == entrenador.id) {
                            pacAux.nombresEntrenador = entrenador.nombresEntrenador
                            pacAux.apellidosEntrenador = entrenador.apellidosEntrenador
                            pacAux.fechaNacimiento = entrenador.fechaNacimiento
                            pacAux.numeroMedallas = entrenador.numeroMedallas
                            pacAux.campeonActual = entrenador.campeonActual
                        }
                    }
                }
            }
            Snackbar
                .make(lv_entrenador, Datos.mensaje(entrenador.opcion), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Datos.listaEntrenador)
        lv_entrenador.adapter = adapter
        lv_entrenador.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            irDatosEntrenador(Datos.listaEntrenador[id.toInt()])
        }


    }

    private fun irDatosEntrenador(entrenador: Entrenador) {
        val intent = Intent(
            this,
            DatosEntrenador::class.java
        )
        intent.putExtra("Entrenador", entrenador)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
