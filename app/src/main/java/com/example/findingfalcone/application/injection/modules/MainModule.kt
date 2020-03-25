package com.example.findingfalcone.application.injection.modules

import androidx.lifecycle.ViewModel
import com.example.findingfalcone.presentation.MainViewModel
import com.example.findingfalcone.application.injection.ViewModelKey
import com.example.findingfalcone.presentation.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}