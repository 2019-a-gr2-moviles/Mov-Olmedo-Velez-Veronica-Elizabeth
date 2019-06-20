package com.example.whatsapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img_entrada.setOnClickListener {
            irARecicler()
        }

    }

    fun irARecicler(){
        val intentExplicito = Intent(
            this,
            ReciclerViewActivity::class.java
        )
        startActivity(intentExplicito)
    }

}