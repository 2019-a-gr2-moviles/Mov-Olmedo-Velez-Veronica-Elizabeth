package com.example.appmaquillaje.modulo_productos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.appmaquillaje.Constantes
import com.example.appmaquillaje.R
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_lista_productos.*

class ListaProductos : AppCompatActivity() {

    private val listaProductos: ArrayList<Producto> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_productos)
        obtenerProducto()
    }

    fun iniciarRecyclerView(listaProductos: ArrayList<Producto>, actividad: ListaProductos, recyclerView: RecyclerView) {
        val adaptadorProducto = AdaptadorListaProductos(listaProductos, actividad, recyclerView)
        rv_maquillaje.adapter = adaptadorProducto
        rv_maquillaje.itemAnimator = DefaultItemAnimator()
        rv_maquillaje.layoutManager = LinearLayoutManager(actividad)

        adaptadorProducto.notifyDataSetChanged()
    }

    fun obtenerProducto() {

        val url = (Constantes.ip + Constantes.producto)
        Log.i("http", url)
        url.httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http", "Data: ${data}")

                        val zapatos = Klaxon()
                            .parseArray<Producto>(data)

                        zapatos?.forEach { producto ->
                            (
                                    this.listaProductos.add(producto)
                            )
                        }
                        runOnUiThread {
                            iniciarRecyclerView(listaProductos, this, rv_maquillaje)
                        }
                    }
                }
            }
    }

    fun irActulizarProducto(producto: Producto) {
        intent = Intent(
            this,
            ActualizarProducto::class.java
        )
        intent.putExtra("producto-marca", producto.marca)
        intent.putExtra("producto-color", producto.color)
        intent.putExtra("producto-existencias", producto.existencias)
        intent.putExtra("producto-tipo", producto.tipo)
        intent.putExtra("producto-cantidad", producto.cantidad)
        intent.putExtra("producto-precio", producto.precio)
        intent.putExtra("producto-id", producto.id)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun eliminarProducto(producto: Producto) {
        val url = "${Constantes.ip}${Constantes.producto}/${producto.id}"

        url.httpDelete()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        runOnUiThread {
                            irListaProductos()
                        }
                    }
                }
            }
    }

    fun irListaProductos() {
        intent = Intent(
            this,
            ListaProductos::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
