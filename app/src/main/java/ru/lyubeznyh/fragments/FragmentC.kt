package ru.lyubeznyh.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import ru.lyubeznyh.fragments.databinding.FragmentCBinding

class FragmentC : Fragment(R.layout.fragment_c) {

    private var _binding: FragmentCBinding? = null
    private val binding get() = _binding!!

    private var textHello: String = UNKNOWN_STRING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textHello = arguments?.getString(STRING_EXTRA) ?: UNKNOWN_STRING
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentCBinding.bind(view)
        with(binding) {
            tvString.text = textHello
            btShowFragmentD.setOnClickListener {
                fragmentNav()?.showFragmentD()
            }
            btShowFragmentA.setOnClickListener {
                fragmentNav()?.showFragmentA()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val FRAGMENT_C_TEG = "FRAGMENT_C_TEG"
        private const val STRING_EXTRA = "STRING_EXTRA"
        private const val UNKNOWN_STRING = "unknown"

        @JvmStatic
        fun newInstant(text: String): FragmentC = FragmentC().apply {
            arguments = bundleOf(STRING_EXTRA to text)
        }
    }
}
