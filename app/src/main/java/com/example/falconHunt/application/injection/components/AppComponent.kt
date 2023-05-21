package com.example.falconHunt.application.injection.components

import androidx.lifecycle.ViewModelProvider
import com.example.falconHunt.application.MyApp
import com.example.falconHunt.application.injection.modules.ApplicationModule
import com.example.falconHunt.application.injection.modules.MainModule
import com.example.falconHunt.application.injection.modules.NetworkModule
import com.example.falconHunt.application.injection.modules.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        MainModule::class,
        ViewModelModule::class,
        NetworkModule::class]
)
interface AppComponent {

    fun inject(app: MyApp)

    // ViewModel factory
    fun viewModelFactory(): ViewModelProvider.Factory
}