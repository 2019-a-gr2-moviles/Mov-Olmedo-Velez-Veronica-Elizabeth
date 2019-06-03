package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable

class Pokemon(
    var id: Int,
    var numeroPokemon: Int,
    var nombrePokemon: String,
    var poderEspecialUno: String,
    var poderEspecialDos: String,
    var fechaCaptura: String,
    var nivel: Int,
    var entrenadorId: Int,
    var opcion: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(numeroPokemon)
        parcel.writeString(nombrePokemon)
        parcel.writeString(poderEspecialUno)
        parcel.writeString(poderEspecialDos)
        parcel.writeString(fechaCaptura)
        parcel.writeInt(nivel)
        parcel.writeInt(entrenadorId)
        parcel.writeInt(opcion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pokemon> {
        override fun createFromParcel(parcel: Parcel): Pokemon {
            return Pokemon(parcel)
        }

        override fun newArray(size: Int): Array<Pokemon?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "${nombrePokemon.toUpperCase()}"
    }

}