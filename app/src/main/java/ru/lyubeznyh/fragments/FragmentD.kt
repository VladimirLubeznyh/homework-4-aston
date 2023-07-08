package ru.lyubeznyh.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.lyubeznyh.fragments.FragmentB.Companion.FRAGMENT_B_TEG
import ru.lyubeznyh.fragments.databinding.FragmentDBinding

class FragmentD : Fragment(R.layout.fragment_d) {

    private var _binding: FragmentDBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentDBinding.bind(view)
        binding.btShowFragmentB.setOnClickListener {
            fragmentNav()?.goToFragment(FRAGMENT_B_TEG)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val FRAGMENT_D_TEG = "FRAGMENT_D_TEG"

        @JvmStatic
        fun newInstant(): FragmentD = FragmentD()
    }
}
