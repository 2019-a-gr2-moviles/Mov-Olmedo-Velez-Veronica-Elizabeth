package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable


class Mascotas (val nombre:String,
                val dueno: Usuario):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readParcelable(Usuario::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeParcelable(dueno, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : android.os.Parcelable.Creator<Mascotas> {
        override fun createFromParcel(parcel: Parcel): Mascotas {
            return Mascotas(parcel)
        }

        override fun newArray(size: Int): Array<Mascotas?> {
            return arrayOfNulls(size)
        }
    }
}