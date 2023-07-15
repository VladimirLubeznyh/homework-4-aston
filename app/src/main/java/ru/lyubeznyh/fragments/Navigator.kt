package ru.lyubeznyh.fragments

import androidx.lifecycle.LifecycleOwner

interface Navigator {

    fun showPersonsFragment()

    fun showSettingPersonFragment(person: Person)

    fun goToBeck()

    fun setListenerChangePerson(result: Person)

    fun listenChangePerson(
        owner: LifecycleOwner,
        listener: (Person) -> Unit
    )
}
