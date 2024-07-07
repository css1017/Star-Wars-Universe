package com.css101.starwarsuniverse.presentation.details

import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.css101.starwarsuniverse.R
import com.css101.starwarsuniverse.databinding.ItemCharactersBinding
import com.css101.starwarsuniverse.domain.models.Character
import java.util.Locale

class CharactersViewHolder(private val binding: ItemCharactersBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Character): Unit = with(binding) {
        when (true) {
            (item.gender.lowercase(Locale.ROOT) == "male") -> {
                setDrawable(R.drawable.ic_face_male)
            }

            (item.gender.lowercase(Locale.ROOT) == "female") -> {
                setDrawable(R.drawable.ic_face_female)
            }

            (item.gender.lowercase(Locale.ROOT) == "n/a") -> {
                setDrawable(R.drawable.ic_face_robot)
            }

            else -> {
                setDrawable(R.drawable.ic_face_other)
            }
        }
        tvPersonSex.text = item.gender
        tvPersonName.text = item.name
        tvPersonBirthDate.text = item.birthYear

    }

    private fun setDrawable(drawable: Int) = with(binding) {
        val context = root.context
        ivPersonDrawable.setImageDrawable(AppCompatResources.getDrawable(context, drawable))
    }
}