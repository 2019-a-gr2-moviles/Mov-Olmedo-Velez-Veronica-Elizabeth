package com.example.whatsapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import android.widget.TextView

class AdaptadorChat(private val listaChat:List<Chat>,
                    private val contexto:ChatActivity,
                    private val recyclerview: RecyclerView
): RecyclerView.Adapter<AdaptadorChat.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txt_usuario_uno:TextView
        var txt_usuario_dos:TextView
        init{
            txt_usuario_uno = view.findViewById(R.id.txt_usuario_uno) as TextView
            txt_usuario_dos = view.findViewById(R.id.txt_usuario_dos) as TextView

           // val layout = view.findViewById(R.id.layout_chat) as LinearLayout



        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorChat.MyViewHolder {

        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_chat,
                p0,
                false
            )

        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
       return listaChat.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorChat.MyViewHolder, position: Int) {
        val chat = listaChat[position]
        myViewHolder.txt_usuario_uno.text = chat.txt_usuario_uno
        myViewHolder.txt_usuario_dos.text = chat.text_usuario_dos





    }
}






