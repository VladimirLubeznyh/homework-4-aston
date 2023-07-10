package ru.lyubeznyh.fragments

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment

fun List<Person>.update(person: Person) = List(size) {
    if (person.id == this[it].id) person
    else this[it]
}

fun getPersonsList() = listOf(
    Person(1, "firstName1", "lastName1", "+74353245", "https://besticon-demo.herokuapp.com/lettericons/A-120-d08125.png"),
    Person(2, "firstName2", "lastName2", "+75464564", "https://besticon-demo.herokuapp.com/lettericons/B-120-d08125.png"),
    Person(3, "firstName3", "lastName3", "+74336354", "https://besticon-demo.herokuapp.com/lettericons/C-120-d08125.png"),
    Person(4, "firstName4", "lastName4", "+72342345", "https://besticon-demo.herokuapp.com/lettericons/D-120-d08125.png"),
)

inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? =
    if (Build.VERSION.SDK_INT >= 33) {
        getParcelable(key, T::class.java)
    } else {
        @Suppress("DEPRECATION")
        getParcelable(key) as? T
    }

fun Fragment.navigator() = (requireActivity() as? Navigator)
