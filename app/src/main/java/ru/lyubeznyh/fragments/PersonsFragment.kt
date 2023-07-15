package ru.lyubeznyh.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import ru.lyubeznyh.fragments.databinding.FragmentPersonsBinding

class PersonsFragment : Fragment(R.layout.fragment_persons) {

    private var _binding: FragmentPersonsBinding? = null
    private val binding get() = _binding!!

    private val adapter = ListDelegationAdapter(personAdapterDelegate() {
        navigator()?.showSettingPersonFragment(it)
    })

    private var list = getPersonsList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentPersonsBinding.bind(view)
        binding.rvPersons.adapter = adapter
        navigator()?.listenChangePerson(viewLifecycleOwner) {
            list = list.update(it)
            adapter.items = list.toList()
        }
        adapter.items = list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val PERSONS_FRAGMENT_TEG = "PERSONS_FRAGMENT_TEG"

        @JvmStatic
        fun newInstance() = PersonsFragment()
    }
}
