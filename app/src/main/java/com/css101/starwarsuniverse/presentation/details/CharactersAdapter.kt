package com.css101.starwarsuniverse.presentation.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.css101.starwarsuniverse.databinding.ItemCharactersBinding
import com.css101.starwarsuniverse.domain.models.Person

class CharactersAdapter(
    private val items: List<Person>,
    private var onItemClick: ((Person) -> Unit),
) : RecyclerView.Adapter<CharactersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharactersBinding.inflate(inflater, parent, false)
        return CharactersViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(items[position])
        val character = items[position]
        holder.itemView.setOnClickListener {
            onItemClick(character)
        }
    }
}