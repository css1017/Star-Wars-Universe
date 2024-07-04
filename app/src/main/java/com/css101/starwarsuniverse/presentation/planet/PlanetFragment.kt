package com.css101.starwarsuniverse.presentation.planet

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.css101.starwarsuniverse.databinding.FragmentPlanetBinding

import com.css101.starwarsuniverse.domain.models.Planet
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlanetFragment : Fragment() {

    private var _binding: FragmentPlanetBinding? = null
    private val binding get() = _binding!!
    private val vm by viewModel<PlanetViewModel>()
    private val args: PlanetFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlanetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.getPlanet(args.planet)
        showLoading()
        vm.planet.observe(viewLifecycleOwner) {
            if (it != null) {
                setData(it)
                hideLoading()
            } else showError()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setData(planet: Planet) = with(binding) {
        tvTitlePlanet.text = planet.name
        tvPlanetClimate.text = planet.climate
        tvPlanetPeople.text = planet.population
        tvPlanetType.text = planet.terrain
        tvPlanetGravity.text = planet.gravity
        tvPlanetDiameter.text = planet.diameter
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