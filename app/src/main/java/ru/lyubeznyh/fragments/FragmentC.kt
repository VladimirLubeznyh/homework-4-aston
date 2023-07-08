package ru.lyubeznyh.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import ru.lyubeznyh.fragments.databinding.FragmentCBinding

class FragmentC : Fragment(R.layout.fragment_c) {

    private var _binding: FragmentCBinding? = null
    private val binding get() = _binding!!

    private var strArg: String = DEFAULT_STRING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        strArg = arguments?.getString(STRING_EXTRA) ?: DEFAULT_STRING
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentCBinding.bind(view)
        binding.tvString.text = strArg

        binding.btShowFragmentD.setOnClickListener {
            fragmentNav()?.showFragmentD()
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

        const val FRAGMENT_C_TEG = "FRAGMENT_C_TEG"
        private const val STRING_EXTRA = "STRING_EXTRA"
        private const val DEFAULT_STRING = "unknown"

        @JvmStatic
        fun newInstant(text: String): FragmentC = FragmentC().apply {
            arguments = bundleOf(STRING_EXTRA to text)
        }
    }
}
