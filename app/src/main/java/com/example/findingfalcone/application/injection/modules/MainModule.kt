package com.example.findingfalcone.application.injection.modules

import androidx.lifecycle.ViewModel
import com.example.findingfalcone.application.injection.ViewModelKey
import com.example.findingfalcone.data.ServiceManager
import com.example.findingfalcone.domain.Repository
import com.example.findingfalcone.presentation.MainActivity
import com.example.findingfalcone.presentation.MainViewModel
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
}