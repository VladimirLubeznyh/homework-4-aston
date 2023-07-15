package ru.lyubeznyh.fragments

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

data class Person(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val photoUrl: String,
) : Parcelable {

    override fun describeContents(): Int = 0

    override fun writeToParcel(parcel: Parcel, p1: Int) {
        parcel.writeInt(id)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(phoneNumber)
        parcel.writeString(photoUrl)
    }

    companion object CREATOR : Creator<Person> {
        override fun createFromParcel(parcel: Parcel?): Person {
            return Person(
                parcel?.readInt() ?: ERROR_INT,
                parcel?.readString() ?: ERROR_STRING,
                parcel?.readString() ?: ERROR_STRING,
                parcel?.readString() ?: ERROR_STRING,
                parcel?.readString() ?: ERROR_STRING
            )
        }

        override fun newArray(size: Int): Array<Person?> = arrayOfNulls(size)

        private const val ERROR_STRING = "unknown"
        private const val ERROR_INT = -1
    }
}
