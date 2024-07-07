package com.css101.starwarsuniverse.presentation.planet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.css101.starwarsuniverse.R
import com.css101.starwarsuniverse.databinding.FragmentPlanetBinding

import com.css101.starwarsuniverse.domain.models.Planet
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlanetFragment : Fragment() {

    private var _binding: FragmentPlanetBinding? = null
    private val binding get() = _binding!!
    private val vm by viewModel<PlanetViewModel>()
    private val args: PlanetFragmentArgs by navArgs()
    private lateinit var navController: NavController

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
        navController = findNavController()
        vm.getPlanet(args.planet)
        showLoading()
        setButtons()
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

    private fun setData(planet: Planet) = with(binding) {
        tvTitlePlanet.text = planet.name
        tvPlanetClimate.text = getString(R.string.climate, planet.climate)
        tvPlanetPeople.text = getString(R.string.population, planet.population)
        tvPlanetType.text = getString(R.string.type, planet.terrain)
        tvPlanetGravity.text = getString(R.string.gravity, planet.gravity)
        tvPlanetDiameter.text = getString(R.string.diameter, planet.diameter)
    }

    private fun setButtons() = with(binding) {
        btnBackPlanet.setOnClickListener { navController.popBackStack() }
    }

    private fun showLoading() = with(binding) {
        tvPlanetDiameter.visibility = View.GONE
        tvPlanetClimate.visibility = View.GONE
        tvPlanetGravity.visibility = View.GONE
        tvPlanetType.visibility = View.GONE
        tvPlanetPeople.visibility = View.GONE
        pbLoadingPlanet.visibility = View.VISIBLE
        tvNoDataPlanet.visibility = View.GONE

    }

    private fun hideLoading() = with(binding) {
        tvPlanetDiameter.visibility = View.VISIBLE
        tvPlanetClimate.visibility = View.VISIBLE
        tvPlanetGravity.visibility = View.VISIBLE
        tvPlanetType.visibility = View.VISIBLE
        tvPlanetPeople.visibility = View.VISIBLE
        pbLoadingPlanet.visibility = View.GONE
        tvNoDataPlanet.visibility = View.GONE
    }

    private fun showError() = with(binding) {
        tvPlanetDiameter.visibility = View.GONE
        tvPlanetClimate.visibility = View.GONE
        tvPlanetGravity.visibility = View.GONE
        tvPlanetType.visibility = View.GONE
        tvPlanetPeople.visibility = View.GONE
        tvNoDataPlanet.visibility = View.VISIBLE
        pbLoadingPlanet.visibility = View.GONE
    }
}