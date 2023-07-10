package ru.lyubeznyh.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.LifecycleOwner
import ru.lyubeznyh.fragments.PersonsFragment.Companion.PERSONS_FRAGMENT_TEG
import ru.lyubeznyh.fragments.SettingPersonFragment.Companion.SETTING_PERSON_FRAGMENT_TEG

class MainActivity : AppCompatActivity(), Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) supportFragmentManager.commit {
            add(R.id.container, PersonsFragment())
        }
    }

    override fun showPersonsFragment() {
        launchFragment(PersonsFragment.newInstance(), PERSONS_FRAGMENT_TEG)
    }

    override fun showSettingPersonFragment(person: Person) {
        launchFragment(
            SettingPersonFragment.newInstance(person),
            SETTING_PERSON_FRAGMENT_TEG
        )
    }

    override fun goToBeck() {
        supportFragmentManager.popBackStack()
    }

    override fun setListenerChangePerson(result: Person) {
        supportFragmentManager.setFragmentResult(RESULT_REQUEST_KEY, bundleOf(RESULT_KEY to result))
    }

    override fun listenChangePerson(
        owner: LifecycleOwner,
        listener: (Person) -> Unit
    ) {
        supportFragmentManager.setFragmentResultListener(RESULT_REQUEST_KEY, owner) { _, result ->
            val tmp = result.parcelable<Person>(RESULT_KEY)
            tmp?.let { listener.invoke(tmp) }
        }
    }

    private fun launchFragment(fragment: Fragment, fragmentTeg: String) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.container, fragment, fragmentTeg)
            addToBackStack(fragmentTeg)
        }
    }

    companion object {
        private const val RESULT_KEY = "RESULT_KEY"
        private const val RESULT_REQUEST_KEY = "RESULT_REQUEST_KEY"
    }
}
