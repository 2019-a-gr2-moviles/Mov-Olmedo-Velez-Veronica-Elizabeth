package com.example.myapplication

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_fragmentos.*

class FragmentosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)

        btn_primero.setOnClickListener{
            abrirPrimerFragmento()
        }

        btn_segundo.setOnClickListener{
            abrirSegundoFragmento()
        }

        btn_tercero.setOnClickListener{
            abrirTercerFragmento()
        }

    }

    fun abrirPrimerFragmento(){
        // 1) Manager
        val fragmentManager = supportFragmentManager
        // 2) Empezar la Transaccion
        val transaccion = fragmentManager.beginTransaction()
        // 3) Definir la instancia del fragmento
        val primeroFragment = PrimeroFragment()
        // 4) Reemplazamos el fragmento
        transaccion.replace(R.id.cly_fragmentos, primeroFragment)
        // 5) Terminar la transaccion
        transaccion.commit()

    }

    fun abrirSegundoFragmento(){
        // 1) Manager
        val fragmentManager = supportFragmentManager
        // 2) Empezar la Transaccion
        val transaccion = fragmentManager.beginTransaction()
        // 3) Definir la instancia del fragmento
        val segundoFragment = SegundoFragment()
        // 4) Reemplazamos el fragmento
        transaccion.replace(R.id.cly_fragmentos, segundoFragment)
        // 5) Terminar la transaccion
        transaccion.commit()

    }

    fun abrirTercerFragmento(){
        // 1) Manager
        val fragmentManager = supportFragmentManager
        // 2) Empezar la Transaccion
        val transaccion = fragmentManager.beginTransaction()
        // 3) Definir la instancia del fragmento
        val tercerFragment = TerceroFragment()
        // 4) Reemplazamos el fragmento

        val argumentos = Budle();
        argumentos.putInt("contador",1)
        tercerFragment.arguments

    }



}
