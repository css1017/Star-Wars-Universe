package com.css101.starwarsuniverse.presentation.details

import androidx.recyclerview.widget.RecyclerView
import com.css101.starwarsuniverse.databinding.ItemCharactersBinding
import com.css101.starwarsuniverse.domain.models.Person

class CharactersViewHolder(private val binding: ItemCharactersBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Person): Unit = with(binding) {
        tvPersonSex.text = item.gender
        tvPersonName.text = item.name
        tvPersonBirthDate.text = item.birthYear

    }


}