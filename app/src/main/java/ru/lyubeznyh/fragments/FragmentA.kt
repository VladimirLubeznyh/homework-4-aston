package ru.lyubeznyh.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.lyubeznyh.fragments.databinding.FargmentABinding

class FragmentA : Fragment(R.layout.fargment_a) {

    private var _binding: FargmentABinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FargmentABinding.bind(view)
        binding.btShowFragmentB.setOnClickListener {
            fragmentNav()?.showFragmentB()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val FRAGMENT_A_TEG = "FRAGMENT_A_TEG"

        @JvmStatic
        fun newInstant(): FragmentA = FragmentA()
    }
}
