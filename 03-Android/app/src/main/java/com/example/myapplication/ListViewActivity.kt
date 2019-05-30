package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.support.design.widget.Snackbar
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.activity_main.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listaNombre = arrayListOf<String>()
        listaNombre.add("Vicente")
        listaNombre.add("Adrian")
        listaNombre.add("Carolina")
        listaNombre.add("Johanna")
        listaNombre.add("Nika")
        listaNombre.add("Jenny")

        //Crear el adaptador

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listaNombre
        )

        //Guardar el adapter
        //AdapterView es la clase que permite acceder

        lv_ejemplo.adapter = adapter

        lv_ejemplo.onItemClickListener = AdapterView
            .OnItemClickListener { parent, view, position, id ->
                Log.i("list-view", "Posicion $position")
                mostrarSnack(view,  "Nombre ${listaNombre[position]},$id")
            }

    }
        fun mostrarSnack(view: View, texto: String) {
            Snackbar
                .make(view, texto, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }
}
