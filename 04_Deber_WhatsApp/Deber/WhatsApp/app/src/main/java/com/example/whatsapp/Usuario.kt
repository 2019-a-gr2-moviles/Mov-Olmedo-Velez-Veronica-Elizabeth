package com.example.whatsapp

import android.media.Image
import android.os.Parcel
import android.os.Parcelable

class Usuario(var nickname: String,
              var mensaje:String,
              var hora: String,
              var id_usuario: Int ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nickname)
        parcel.writeString(mensaje)
        parcel.writeString(hora)
        parcel.writeInt(id_usuario)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario {
            return Usuario(parcel)
        }

        override fun newArray(size: Int): Array<Usuario?> {
            return arrayOfNulls(size)
        }
    }


}