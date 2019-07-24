package com.example.appmaquillaje.modulo_productos


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.appmaquillaje.R

class AdaptadorListaProductos(
    private val listaProductos: ArrayList<Producto>,
    private val contexto: ListaProductos,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorListaProductos.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var marcaTextView: TextView
        var colorTextView: TextView
        var existenciasTextView: TextView
        var tipoTextView: TextView
        var cantidadTextView: TextView
        var precioTextView: TextView
        var idTextView: TextView
        var eliminarBoton: Button


        init {
            marcaTextView = view.findViewById(R.id.txt_mar_pro) as TextView
            colorTextView = view.findViewById(R.id.txt_col_pro) as TextView
            existenciasTextView = view.findViewById(R.id.txt_exi_pro) as TextView
            tipoTextView = view.findViewById(R.id.txt_tip_pro) as TextView
            cantidadTextView = view.findViewById(R.id.txt_can_pro) as TextView
            precioTextView = view.findViewById(R.id.txt_pre_pro) as TextView
            idTextView = view.findViewById(R.id.txt_id_pro) as TextView
            eliminarBoton = view.findViewById(R.id.btn_eli_pro) as Button

            val layout = view.findViewById(R.id.lay_cam_pro) as LinearLayout
            layout.setOnClickListener {
                val producto = crearProducto(
                    idTextView.text.toString().toInt(),
                    marcaTextView.text.toString(),
                    colorTextView.text.toString(),
                    existenciasTextView.text.toString().toInt(),
                    tipoTextView.text.toString(),
                    cantidadTextView.text.toString().toInt(),
                    precioTextView.text.toString().toDouble()

                )
                contexto.irActulizarProducto(producto)
            }

            eliminarBoton.setOnClickListener {
                val producto = crearProducto(
                    idTextView.text.toString().toInt(),
                    marcaTextView.text.toString(),
                    colorTextView.text.toString(),
                    existenciasTextView.text.toString().toInt(),
                    tipoTextView.text.toString(),
                    cantidadTextView.text.toString().toInt(),
                    precioTextView.text.toString().toDouble()
                )
                contexto.eliminarProducto(producto)

            }

        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorListaProductos.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_productos,
                p0,
                false
            )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorListaProductos.MyViewHolder, position: Int){
        val producto: Producto = listaProductos[position]
        myViewHolder.marcaTextView.text = producto.marca
        myViewHolder.colorTextView.text = producto.color
        myViewHolder.existenciasTextView.text = producto.existencias.toString()
        myViewHolder.tipoTextView.text = producto.tipo
        myViewHolder.cantidadTextView.text = producto.cantidad.toString()
        myViewHolder.precioTextView.text = producto.precio.toString()
        myViewHolder.idTextView.text = producto.id.toString()

    }


    fun crearProducto(id: Int, marca: String, color: String, existencias: Int, tipo: String, cantidad: Int, precio: Double): Producto {
        val producto = Producto(
            null,
            null,
            id,
            marca,
            color,
            existencias,
            tipo,
            cantidad,
            precio
        )
        return producto
    }
}