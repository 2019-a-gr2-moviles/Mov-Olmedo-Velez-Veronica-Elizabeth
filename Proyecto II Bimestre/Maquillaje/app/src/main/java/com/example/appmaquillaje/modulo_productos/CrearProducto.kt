package com.example.appmaquillaje.modulo_productos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appmaquillaje.Constantes
import com.example.appmaquillaje.R
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_crear_producto.*

class CrearProducto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_producto)
        btn_ing_product.setOnClickListener {
            if (validar()) {
                val producto = Producto(
                    null,
                    null,
                    null,
//                    null
                    txt_ing_mar_pro.text.toString(),
                    txt_ing_col_pro.text.toString(),
                    txt_ing_exi_pro.text.toString().toInt(),
                    txt_ing_tip_pro.text.toString(),
                    txt_ing_can_pro.text.toString().toInt(),
                    txt_ing_pre_pro.text.toString().toDouble()
                )
                ingresarProducto(producto)
            }
        }
    }

    fun ingresarProducto(producto: Producto) {

        val url = Constantes.ip + Constantes.producto
        val json = """
            {
            "marca": "${producto.marca}",
            "color": "${producto.color}",
            "existencias": ${producto.existencias},
            "tipo": "${producto.tipo}",
            "cantidad": ${producto.cantidad},
            "precio": ${producto.precio}
            }
                    """
        Log.i("http-json", json)
        url.httpPost().body(json)
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

    fun validar(): Boolean {
        if (txt_ing_mar_pro.text == null || txt_ing_col_pro.text == null || txt_ing_exi_pro.text == null
            || txt_ing_can_pro.text == null|| txt_ing_pre_pro.text == null) {
            return false
        }
        return true
    }

    fun irListaProductos() {
        intent = Intent(
            this,
            ListaProductos::class.java
        )
        startActivity(intent)
    }
}
