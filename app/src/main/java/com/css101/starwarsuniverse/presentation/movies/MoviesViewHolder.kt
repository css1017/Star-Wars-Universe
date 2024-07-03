package com.css101.starwarsuniverse.presentation.movies

import androidx.recyclerview.widget.RecyclerView
import com.css101.starwarsuniverse.databinding.ItemMoviesBinding
import com.css101.starwarsuniverse.domain.models.Film

class MoviesViewHolder(private val binding: ItemMoviesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Film): Unit = with(binding) {
        tvMovieDate.text = item.releaseDate
        tvMovieName.text = item.title
        tvMovieDirector.text = item.director
        tvMovieProducer.text = item.producer

    }


}