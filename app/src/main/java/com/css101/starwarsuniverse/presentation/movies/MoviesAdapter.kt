package com.css101.starwarsuniverse.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.css101.starwarsuniverse.databinding.ItemMoviesBinding
import com.css101.starwarsuniverse.domain.models.Film

class MoviesAdapter(
    private val items: List<Film>,
    private var onItemClick: ((Film) -> Unit),
) : RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMoviesBinding.inflate(inflater, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(items[position])
        val movie = items[position]
        holder.itemView.setOnClickListener {
            onItemClick(movie)
        }
    }
}