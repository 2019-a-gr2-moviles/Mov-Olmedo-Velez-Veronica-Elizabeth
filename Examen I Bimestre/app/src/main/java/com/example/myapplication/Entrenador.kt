package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable
import java.lang.StringBuilder

class Entrenador
    (
    var id: Int,
    var nombresEntrenador: String,
    var apellidosEntrenador: String,
    var fechaNacimiento: String,
    var numeroMedallas: Int,
    var campeonActual: Boolean,
    var opcion: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt()

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nombresEntrenador)
        parcel.writeString(apellidosEntrenador)
        parcel.writeString(fechaNacimiento)
        parcel.writeInt(numeroMedallas)
        parcel.writeByte(if (campeonActual) 1 else 0)
        parcel.writeInt(opcion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Entrenador> {
        override fun createFromParcel(parcel: Parcel): Entrenador {
            return Entrenador(parcel)
        }

        override fun newArray(size: Int): Array<Entrenador?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "${nombresEntrenador.toUpperCase()} ${apellidosEntrenador.toUpperCase()}"
    }

}