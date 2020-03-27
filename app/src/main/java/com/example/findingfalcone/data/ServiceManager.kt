package com.example.findingfalcone.data

import com.example.findingfalcone.domain.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ServiceManager @Inject constructor(private val service: Service) : Repository {
}