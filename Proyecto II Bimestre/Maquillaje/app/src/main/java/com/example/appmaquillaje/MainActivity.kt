package com.example.appmaquillaje

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.appmaquillaje.modulo_clientes.MenuClientes
import com.example.appmaquillaje.modulo_compras.MenuCompras
import com.example.appmaquillaje.modulo_productos.MenuProducto
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_catalogo.setOnClickListener {
            irMenuProducto()
        }

        btn_clientes.setOnClickListener {
            irMenuClientes()
        }
        btn_compras.setOnClickListener {
            irMenuCompras()
        }
    }

    fun irMenuProducto() {
        val intent = Intent(
            this,
            MenuProducto::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    fun irMenuClientes() {
        val intent = Intent(
            this,
            MenuClientes::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun irMenuCompras() {
        val intent = Intent(
            this,
            MenuCompras::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
