package com.css101.starwarsuniverse.presentation.movies

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.css101.starwarsuniverse.databinding.FragmentMoviesBinding
import com.css101.starwarsuniverse.domain.models.Film
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private val vm by viewModel<MoviesViewModel>()
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        vm.getMovies()
        setSearch()
        showLoading()
        vm.movies.observe(viewLifecycleOwner) {
            if (it.isEmpty()) showError() else hideLoading()
            setAdapter(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setAdapter(movies: List<Film>) = with(binding) {
        rvMovies.adapter = MoviesAdapter(movies) {
            val action = MoviesFragmentDirections.actionMoviesToDetails(it.url)
            navController.navigate(action)
        }
        rvMovies.adapter?.notifyDataSetChanged()
    }

    private fun showLoading() = with(binding) {
        pbLoadingMovies.visibility = View.VISIBLE
        tvErrorMovies.visibility = View.GONE

    }

    private fun hideLoading() = with(binding) {
        pbLoadingMovies.visibility = View.GONE
        tvErrorMovies.visibility = View.GONE
    }

    private fun showError() = with(binding) {
        pbLoadingMovies.visibility = View.GONE
        tvErrorMovies.visibility = View.VISIBLE
    }

    private fun setSearch() = with(binding) {
        svMovies.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = false

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredMovies = if (!newText.isNullOrEmpty()) {
                    vm.movies.value?.filter { movie ->
                        movie.title.contains(newText, ignoreCase = true)
                    }
                } else {
                    vm.movies.value
                }
                setAdapter(filteredMovies ?: emptyList())
                return true
            }
        })
    }
}