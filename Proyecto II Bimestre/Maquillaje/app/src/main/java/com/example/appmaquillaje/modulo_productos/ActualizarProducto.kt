package com.example.appmaquillaje.modulo_productos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appmaquillaje.Constantes
import com.example.appmaquillaje.R
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_actualizar_producto.*

class ActualizarProducto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_producto)

        val productoMarca: String? = this.intent.getStringExtra("producto-marca")
        val productoColor: String? = this.intent.getStringExtra("producto-color")
        val productoTipo: String? = this.intent.getStringExtra("producto-tipo")
        val productoExistencias: Int? = this.intent.getIntExtra("producto-existencias", -1)
        val productoId: Int? = this.intent.getIntExtra("producto-id", -1)
        val productoCantidad: Int? = this.intent.getIntExtra("producto-cantidad", -1)
        val productoPrecio: Double? = this.intent.getDoubleExtra("producto-precio", -1.0)

        Log.i(
            "http",
            "$productoId $productoMarca $productoColor $productoExistencias $productoTipo $productoCantidad $productoPrecio"
        )

        txt_act_id_pro.text = productoId.toString()
        txt_act_mar_pro.hint = productoMarca
        txt_act_col_pro.hint = productoColor
        txt_act_tip_pro.hint = productoTipo
        txt_act_exi_pro.hint = productoExistencias.toString()
        txt_act_can_pro.hint = productoCantidad.toString()
        txt_act_pre_pro.hint = productoPrecio.toString()

        btn_act_zap.setOnClickListener {
            val producto = Producto(
//                null,
                null,
                null,
                txt_act_id_pro.text.toString().toInt(),
                txt_act_mar_pro.text.toString(),
                txt_act_col_pro.text.toString(),
                txt_act_exi_pro.text.toString().toInt(),
                txt_act_tip_pro.text.toString(),
                txt_act_can_pro.text.toString().toInt(),
                txt_act_pre_pro.text.toString().toDouble()
            )
            actualizarProducto(producto)
        }
    }

    fun actualizarProducto(producto: Producto) {

        val url = Constantes.ip + Constantes.producto+ "/${producto.id}"
        val json = """
            {
            "marca": "${producto.marca}",
            "color": "${producto.color}",
            "tipo": "${producto.tipo}",
            "existencias": ${producto.existencias},
            "cantidad": ${producto.cantidad},
            "precio": ${producto.precio}
                                   }
                    """

        url.httpPut().body(json)
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        Log.i("http", "$response")
                        runOnUiThread {
                            irListaProducto()
                        }
                    }
                }
            }
    }

    fun irListaProducto() {
        intent = Intent(
            this,
            ListaProductos::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
