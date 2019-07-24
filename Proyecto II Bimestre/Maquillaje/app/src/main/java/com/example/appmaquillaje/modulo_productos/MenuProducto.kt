package com.example.appmaquillaje.modulo_productos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.appmaquillaje.R
import kotlinx.android.synthetic.main.activity_menu_productos.*

class MenuProducto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_productos)
        btn_ver_product.setOnClickListener {
            ListaProductos()
        }

        btn_ing_product.setOnClickListener {
            CrearProducto()
        }

        btn_mod_product.setOnClickListener {
            ListaProductos()
        }
    }

    fun ListaProductos() {
        intent = Intent(
            this,
            ListaProductos::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun CrearProducto() {
        intent = Intent(
            this,
            CrearProducto::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
