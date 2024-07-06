package com.css101.starwarsuniverse.presentation.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.css101.starwarsuniverse.databinding.FragmentMovieDetailsBinding
import com.css101.starwarsuniverse.domain.models.Character
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!
    private val vm by viewModel<DetailsViewModel>()
    private lateinit var navController: NavController
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        vm.getCharacters(args.episodeId)
        showLoading()
        binding.tvTitlePerson.text = args.episodeId.toString()
        vm.characters.observe(viewLifecycleOwner) {
            if (it.isEmpty()) showError() else hideLoading()
            setAdapter(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setAdapter(movies: List<Character>) = with(binding) {
        rvCaracters.adapter = CharactersAdapter(movies) {
            val action = DetailsFragmentDirections.actionDetailsToPlanet(it.homeWorld)
            navController.navigate(action)
        }
        rvCaracters.adapter?.notifyDataSetChanged()
    }

    private fun showLoading() = with(binding) {
//        pbLoadingMovies.visibility = View.VISIBLE
//        tvErrorMovies.visibility = View.GONE

    }

    private fun hideLoading() = with(binding) {
//        pbLoadingMovies.visibility = View.GONE
//        tvErrorMovies.visibility = View.GONE
    }

    private fun showError() = with(binding) {
//        pbLoadingMovies.visibility = View.GONE
//        tvErrorMovies.visibility = View.VISIBLE
    }
}