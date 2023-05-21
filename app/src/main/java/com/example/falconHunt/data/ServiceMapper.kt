package com.example.falconHunt.data

import com.example.falconHunt.data.model.FindApiResponse
import com.example.falconHunt.data.model.PlanetsApiResponse
import com.example.falconHunt.data.model.VehiclesApiResponse
import com.example.falconHunt.domain.model.FindResponse
import com.example.falconHunt.domain.model.Planet
import com.example.falconHunt.domain.model.Vehicle

fun PlanetsApiResponse.mapToPlanet() = Planet(name, distance)

fun VehiclesApiResponse.mapToVehicle() = Vehicle(name, amount, maxDistance, speed)

fun FindApiResponse.mapToFindResponse() =
    when (status) {
        "success" -> FindResponse.Success(planetName!!)
        "false" -> FindResponse.Failure
        else -> throw SecurityException(error)
    }