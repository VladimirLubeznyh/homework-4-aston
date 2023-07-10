package ru.lyubeznyh.fragments

import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.lyubeznyh.fragments.databinding.ItemPersonBinding

fun personAdapterDelegate(onClickItem: (Person) -> Unit) =
    adapterDelegateViewBinding<Person, Person, ItemPersonBinding>(
        { layoutInflater, parent ->
            ItemPersonBinding.inflate(layoutInflater, parent, false)
        }) {
        bind {
            with(binding) {
                tvFirstName.text = item.firstName
                tvLastName.text = item.lastName
                tvPhoneNumber.text = item.phoneNumber
                Glide
                    .with(itemView)
                    .load(item.photoUrl)
                    .error(R.drawable.ic_launcher_background)
                    .into(ivPhoto)
            }
        }
        binding.root.setOnClickListener {
            onClickItem.invoke(item)
        }
    }
