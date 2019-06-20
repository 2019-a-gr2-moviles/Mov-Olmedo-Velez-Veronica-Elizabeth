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
        listachat.add(Chat(":D Hace mucho tiempo que no hablamos","Es tengo mucho trabajo"))
        listachat.add(Chat("Te apetece quedar para un café","Si cuando :P"))
        listachat.add(Chat("Mañana","Ok"))
        listachat.add(Chat("En la tarde","Mejor en la mañana"))
        listachat.add(Chat("Ok","Entonces te llamo"))
        listachat.add(Chat("Vale","Cuidate"))
        listachat.add(Chat("Gracias tu tambien","Saludame a Jenny"))
        listachat.add(Chat("Ok","Adios!!"))


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
            1 -> { img_profile_image.setImageResource(R.drawable.a1) }
            2 -> { img_profile_image.setImageResource(R.drawable.a2) }
            3 -> { img_profile_image.setImageResource(R.drawable.a3) }
            4 -> { img_profile_image.setImageResource(R.drawable.a4) }
            5 -> { img_profile_image.setImageResource(R.drawable.a5) }
            6 -> { img_profile_image.setImageResource(R.drawable.a6) }
            7 -> { img_profile_image.setImageResource(R.drawable.a7) }
            8 -> { img_profile_image.setImageResource(R.drawable.a8) }
            9 -> { img_profile_image.setImageResource(R.drawable.a9) }
            10 -> { img_profile_image.setImageResource(R.drawable.a10) }
            else ->{img_profile_image.setImageResource(R.drawable.a1)}
            }
        txt_mensaje.text = "En Linea"
        txt_nombre_usuario_chat.text = mensaje.nickname




        }

    }



