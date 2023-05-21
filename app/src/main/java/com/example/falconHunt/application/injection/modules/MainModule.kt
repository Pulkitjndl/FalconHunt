package com.example.falconHunt.application.injection.modules

import androidx.lifecycle.ViewModel
import com.example.falconHunt.application.injection.ViewModelKey
import com.example.falconHunt.data.ServiceManager
import com.example.falconHunt.domain.Repository
import com.example.falconHunt.presentation.MainActivity
import com.example.falconHunt.presentation.MainViewModel
import com.example.falconHunt.presentation.find.FindActivity
import com.example.falconHunt.presentation.find.FindViewModel
import com.example.falconHunt.presentation.vehicleselection.VehicleSelectionActivity
import com.example.falconHunt.presentation.vehicleselection.VehicleSelectionViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {

    @Binds
    abstract fun bindRepository(manager: ServiceManager): Repository

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun bindVehicleSelectionActivity(): VehicleSelectionActivity

    @Binds
    @IntoMap
    @ViewModelKey(VehicleSelectionViewModel::class)
    abstract fun bindVehicleSelectionViewModel(viewModel: VehicleSelectionViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun bindFindActivity(): FindActivity

    @Binds
    @IntoMap
    @ViewModelKey(FindViewModel::class)
    abstract fun bindFindViewModel(viewModel: FindViewModel): ViewModel
}