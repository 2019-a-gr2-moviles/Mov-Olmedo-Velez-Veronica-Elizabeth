package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_parcelable.setOnClickListener {
            irAParcelable()
        }
        btn_adapter.setOnClickListener {
            irAListView()
        }
    }

    fun irAParcelable(){
        val intentExplicito = Intent(
            this,
            Parcelable::class.java
        )
        val nika = Usuario("Nika",
            24,
            Date(),
            100.50)
        intentExplicito.putExtra("usuario",nika)
        startActivity(intentExplicito)

        val cachetes = Mascotas("Cachetes", nika)
        intentExplicito.putExtra("mascotas",cachetes)
        startActivity(intentExplicito)
    }


    fun irAListView(){
        val intentExplicito = Intent(
            this,
            ListViewActivity::class.java
        )
        startActivity(intentExplicito)
    }


}
