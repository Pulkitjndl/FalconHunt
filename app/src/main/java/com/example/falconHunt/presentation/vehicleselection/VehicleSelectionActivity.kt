package com.example.falconHunt.presentation.vehicleselection

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.falconHunt.R
import com.example.falconHunt.application.extensions.getViewModel
import com.example.falconHunt.application.extensions.observe
import com.example.falconHunt.domain.model.Planet
import com.example.falconHunt.domain.model.Vehicle
import com.example.falconHunt.presentation.vehicleselection.VehicleSelectionViewModel.NavigationEvent
import com.example.falconHunt.presentation.vehicleselection.VehicleSelectionViewModel.ViewState
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_vehicle_selection.*
import javax.inject.Inject

class VehicleSelectionActivity : AppCompatActivity() {

    companion object {
        const val PLANET = "planet"
        const val VEHICLE = "vehicle"

        fun intent(context: Context, planet: Planet, vehicles: ArrayList<Vehicle>) =
            Intent(context, VehicleSelectionActivity::class.java).apply {
                putExtra(PLANET, planet)
                putParcelableArrayListExtra(VEHICLE, vehicles)
            }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: VehicleSelectionViewModel

    private val programsAdapter by lazy { VehicleAdapter(viewModel::onItemClicked) }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_selection)

        viewModel = getViewModel(viewModelFactory)
        viewModel.viewState.observe(this, onChange = ::renderView)
        viewModel.navigation.observe(this, onChange = ::navigate)

        vehicleRecyclerView.apply {
            layoutManager =
                StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            adapter = programsAdapter
        }

        val selectedPlanet = requireNotNull(intent.getParcelableExtra<Planet>(PLANET)) { "no planet selected" }
        viewModel.init(selectedPlanet, intent.getParcelableArrayListExtra(VEHICLE) ?: arrayListOf())
    }

    private fun renderView(state: ViewState) {
        emptyText.visibility = View.INVISIBLE
        vehicleRecyclerView.visibility = View.VISIBLE
        programsAdapter.updateList(state.vehicles)
    }

    private fun navigate(event: NavigationEvent) {
        val intent = Intent().apply {
            putExtra(PLANET, event.planet)
            putExtra(VEHICLE, event.vehicle)
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}