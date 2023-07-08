package ru.lyubeznyh.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import ru.lyubeznyh.fragments.FragmentA.Companion.FRAGMENT_A_TEG
import ru.lyubeznyh.fragments.FragmentB.Companion.FRAGMENT_B_TEG
import ru.lyubeznyh.fragments.FragmentC.Companion.FRAGMENT_C_TEG
import ru.lyubeznyh.fragments.FragmentD.Companion.FRAGMENT_D_TEG

class MainActivity : AppCompatActivity(), FragmentNavigation {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.container, FragmentA.newInstant(), FRAGMENT_A_TEG)
            }
        }
    }

    override fun showFragmentA() {
        launchFragment(FragmentA.newInstant(), FRAGMENT_A_TEG)
    }

    override fun showFragmentB() {
        launchFragment(FragmentB.newInstant(), FRAGMENT_B_TEG)
    }

    override fun showFragmentC(text: String) {
        launchFragment(FragmentC.newInstant(text), FRAGMENT_C_TEG)
    }

    override fun showFragmentD() {
        launchFragment(FragmentD.newInstant(), FRAGMENT_D_TEG)
    }

    override fun goToBack() {
        supportFragmentManager.popBackStack()
    }

    override fun goToFragment(fragmentTeg: String) {
        supportFragmentManager.popBackStack(fragmentTeg, 0)
    }

    private fun launchFragment(fragment: Fragment, teg: String) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.container, fragment, teg)
            addToBackStack(teg)
        }
    }
}
