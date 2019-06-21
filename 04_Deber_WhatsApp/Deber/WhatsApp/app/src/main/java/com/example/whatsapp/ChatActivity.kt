package com.example.whatsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val mensaje:Usuario?= this.intent.getParcelableExtra<Usuario>("mensaje")
        Log.i("mensaje", "Mensajee ${mensaje?.nickname}")
        llenarDatos(mensaje!!)


        var listachat = arrayListOf<Chat>()



        listachat.add(Chat("Hola como estas? ","Bien y tu?"))
        listachat.add(Chat(":D Hace mucho tiempo que no hablamos","Es tengo mucho trabajo en la universidad"))
        listachat.add(Chat("Te apetece quedar para un café o almorzar","Si cuando :P"))
        listachat.add(Chat("Mañana","Ok"))
        listachat.add(Chat("En la tarde","Mañana??"))
        listachat.add(Chat("Ok","Te llamo en la tarde para confirmarte"))
        listachat.add(Chat("Vale","Cuidate Mucho"))
        listachat.add(Chat("Gracias tu tambien","Saluda a Jenny"))
        listachat.add(Chat("Ok Muchacha","Adios!!"))


        iniciarRecylerView(listachat,this,recicler_view_chats)



    }
    fun iniciarRecylerView(
        lista: List<Chat>,
        actividad: ChatActivity,
        recycler_view: RecyclerView
    ) {
        val adaptadorchat = AdaptadorChat(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorchat
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorchat.notifyDataSetChanged()
    }


    fun llenarDatos(mensaje:Usuario){


        when(mensaje.id_usuario){
            1 -> { img_prerfil.setImageResource(R.drawable.a1) }
            2 -> { img_prerfil.setImageResource(R.drawable.a2) }
            3 -> { img_prerfil.setImageResource(R.drawable.a3) }
            4 -> { img_prerfil.setImageResource(R.drawable.a4) }
            5 -> { img_prerfil.setImageResource(R.drawable.a5) }
            6 -> { img_prerfil.setImageResource(R.drawable.a6) }
            7 -> { img_prerfil.setImageResource(R.drawable.a7) }
            8 -> { img_prerfil.setImageResource(R.drawable.a8) }
            9 -> { img_prerfil.setImageResource(R.drawable.a9) }
            10 -> { img_prerfil.setImageResource(R.drawable.a10) }
            else ->{img_prerfil.setImageResource(R.drawable.a1)}
            }
        txt_mensaje.text = "en línea"
        txt_usuario_chat.text = mensaje.nickname




        }

    }



