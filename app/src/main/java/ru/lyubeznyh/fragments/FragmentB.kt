package ru.lyubeznyh.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.lyubeznyh.fragments.databinding.FragmentBBinding

class FragmentB : Fragment(R.layout.fragment_b) {
    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentBBinding.bind(view)

        binding.btShowFragmentC.setOnClickListener {
            fragmentNav()?.showFragmentC("Hello fragment C")
        }
        binding.btShowFragmentA.setOnClickListener {
            fragmentNav()?.showFragmentA()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val FRAGMENT_B_TEG = "FRAGMENT_B_TEG"

        @JvmStatic
        fun newInstant(): FragmentB = FragmentB()
    }
}
