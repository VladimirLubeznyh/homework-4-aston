package ru.lyubeznyh.fragments

import androidx.fragment.app.Fragment

interface FragmentNavigation {

    fun showFragmentA()

    fun showFragmentB()

    fun showFragmentC(text: String)

    fun showFragmentD()

    fun goToBack()

    fun goToFragment(fragmentTeg: String)

}

fun Fragment.fragmentNav(): FragmentNavigation? = (requireActivity() as? FragmentNavigation)
