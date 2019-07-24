package com.example.appmaquillaje.modulo_compras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.beust.klaxon.Klaxon
import com.example.appmaquillaje.Constantes
import com.example.appmaquillaje.R
import com.example.appmaquillaje.clases_auxiliares.ClienteAux
import com.example.appmaquillaje.clases_auxiliares.ProductoAux
import com.example.appmaquillaje.modulo_clientes.Cliente
import com.example.appmaquillaje.modulo_productos.Producto
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_crear_compra.*
import java.lang.Exception


class CrearCompra : AppCompatActivity() {
    private var listaClientes: ArrayList<Cliente>
    private var listaProducto: ArrayList<Producto>
    init {
        listaProducto = arrayListOf<Producto>()
        listaClientes = arrayListOf<Cliente>()

        obtenerProducto()
        obtenerClientes()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_compra)

        btn_ing_com.setOnClickListener {
            try {

                val producto = listaProducto.find { producto ->
                    producto.id == txt_ing_id_pro_com.text.toString().toInt()
                }

                val cliente = listaClientes.find { cliente ->
                    cliente.cedula == txt_ing_ced_cli_com.text.toString()
                }

//                Log.i("http", "Cliente: ${cliente.cedula}")
//                Log.i("http", "Zapato: ${zapato.id}")

                if (producto != null && cliente != null) {
                    val fechaActual = "2019/07/19"
                    val total: Double = producto.precio * (txt_ing_can_pro.text.toString().toInt())
                    val compra = Compra(
                        null,
                        fechaActual,
                        txt_ing_can_pro.text.toString().toInt(),
                        total,
                        null,
                        ClienteAux(cliente.id, null, null, null),
                        ProductoAux(txt_ing_id_pro_com.text.toString().toInt(), null, null, null, null, null, null)
                    )

                    ingresarCompra(compra)
                    Toast.makeText(this, "Compra ingresada correctamente", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(this, "Cédula o código del zapato no valido", Toast.LENGTH_LONG).show();
                }
//            }
            } catch (e: Exception) {
                Toast.makeText(this, "Cédula o código del zapato no valido", Toast.LENGTH_LONG).show();
            }
        }
    }

    fun obtenerProducto() {
        val url = "${Constantes.ip}${Constantes.producto}"
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
//                        Log.i("http", "Data: ${data}")

                        val zapatos = Klaxon()
                            .parseArray<Producto>(data)

                        zapatos?.forEach { producto ->
                            (
                                    this.listaProducto.add(producto)
                                    )
                        }
                    }
                }
            }
    }

    fun obtenerClientes() {
        //this.listaClientes.clear()
        try {
            val url = (Constantes.ip + Constantes.cliente)
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
//                            Log.i("http", "Data: ${data}")

                            val clientes = Klaxon()
                                .parseArray<Cliente>(data)

                            clientes?.forEach { cliente ->
                                (
                                        this.listaClientes.add(cliente)
                                        )
                            }
                        }
                    }
                }
        } catch (e: Exception) {
            Log.i("http", "${e}")
        }
    }

    fun ingresarCompra(compra: Compra) {
        val url = Constantes.ip + Constantes.compra
        val json = """
            {
            "fecha": "${compra.fecha}",
            "cantidad": ${compra.cantidad},
            "total": ${compra.total},
            "codigoCli": ${compra.codigoCli!!.id},
            "codigoProd": ${compra.codigoProd!!.id}
                        }
                    """

        url.httpPost().body(json)
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        runOnUiThread {
                            irListaCompras()
                        }
                    }
                }
            }
    }

    fun irListaCompras() {
        intent = Intent(
            this,
            ListaCompras::class.java
        )
        startActivity(intent)
    }
}
