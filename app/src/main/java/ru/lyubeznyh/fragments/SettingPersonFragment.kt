package ru.lyubeznyh.fragments

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ru.lyubeznyh.fragments.databinding.FragmentSettingPersonBinding

class SettingPersonFragment : Fragment(R.layout.fragment_setting_person) {

    private var _binding: FragmentSettingPersonBinding? = null
    private val binding get() = _binding!!

    private var person: Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            person = parcelable(PERSON_EXTRA)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentSettingPersonBinding.bind(view)

        person?.let(::setPersonDataToView)

        binding.btSave.setOnClickListener {
            onClickSaveButton()
        }

        binding.btCancel.setOnClickListener {
            navigator()?.goToBeck()
        }
    }

    private fun setPersonDataToView(person: Person) {
        with(binding) {
            etFirstName.setText(person.firstName)
            etLastName.setText(person.lastName)
            etPhoneNumber.setText(person.phoneNumber)
            Glide
                .with(requireContext())
                .load(person.photoUrl)
                .error(R.drawable.ic_launcher_background).into(ivPhoto)
        }
    }

    private fun onClickSaveButton() {
        person = person?.copy(
            firstName = binding.etFirstName.text.toString(),
            lastName = binding.etLastName.text.toString(),
            phoneNumber = binding.etPhoneNumber.text.toString()
        )
        person?.let { navigator()?.setListenerChangePerson(it) }
        navigator()?.goToBeck()
    }

    private fun closeKeyboard() {
        val imm =
            getSystemService(requireContext(), InputMethodManager::class.java) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        closeKeyboard()
        _binding = null
    }

    companion object {
        const val SETTING_PERSON_FRAGMENT_TEG = "SETTING_PERSON_FRAGMENT_TEG"
        private const val PERSON_EXTRA = "PERSON_EXTRA"

        @JvmStatic
        fun newInstance(person: Person) =
            SettingPersonFragment().apply {
                arguments = bundleOf(PERSON_EXTRA to person)
            }
    }
}
