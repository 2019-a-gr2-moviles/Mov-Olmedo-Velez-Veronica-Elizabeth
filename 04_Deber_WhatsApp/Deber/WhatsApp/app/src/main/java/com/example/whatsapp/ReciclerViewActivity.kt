package com.example.whatsapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recicler_view.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)
        var listaUsuario = arrayListOf<Usuario>()


        listaUsuario.add(Usuario("Michael","????","17:30",1))
        listaUsuario.add(Usuario("Alex","Gracias","10:40",2))
        listaUsuario.add(Usuario("Yoli","Ok bebe","9:50",3))
        listaUsuario.add(Usuario("Cris","Ola wapa","5:45",4))
        listaUsuario.add(Usuario("Jenny","Te echo de menos","3:10",5))
        listaUsuario.add(Usuario("Annita","Donde estas?","Ayer",6))
        listaUsuario.add(Usuario("Turista","Que haces?","Ayer",7))
        listaUsuario.add(Usuario("Bryan","Cuando vienes?","Ayer",8))
        listaUsuario.add(Usuario("Carli","https://www.canvas.com","17/06/2019",9))
        listaUsuario.add(Usuario("Danny",":D","16/06/2019",10))
        listaUsuario.add(Usuario("Morales","Te espero","15/05/2019",1))
        listaUsuario.add(Usuario("Carillo","Ola :D","14/05/2019",2))
        listaUsuario.add(Usuario("Yoli","Ok bebe","9:50",3))
        listaUsuario.add(Usuario("Cris","Ola wapa","5:45",4))
        listaUsuario.add(Usuario("Jenny","Te echo de menos","3:10",5))
        listaUsuario.add(Usuario("Annita","Donde estas?","Ayer",6))
        listaUsuario.add(Usuario("Turista","Que haces?","Ayer",7))
        listaUsuario.add(Usuario("Bryan","Cuando vienes?","Ayer",8))
        listaUsuario.add(Usuario("Carli","https://www.canvas.com","17/06/2019",9))
        listaUsuario.add(Usuario("Danny",":D","16/06/2019",10))

        iniciarRecylerView(listaUsuario,this,recycler_view_mensajes)


    }



    fun iniciarRecylerView(
        lista: List<Usuario>,
        actividad: ReciclerViewActivity,
        recycler_view: RecyclerView
    ) {
        val adaptadorMensaje = AdaptadorAmigos(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorMensaje
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorMensaje.notifyDataSetChanged()
    }


    fun irAChatAcivity(mensaje: Usuario){
        val intentExplicito = Intent(
            this,
            ChatActivity::class.java
        )


        intentExplicito.putExtra("mensaje",mensaje)
        startActivity(intentExplicito)


    }









}
