package com.example.falconHunt.data

import com.example.falconHunt.data.model.FindApiRequest
import com.example.falconHunt.data.model.FindApiResponse
import com.example.falconHunt.data.model.PlanetsApiResponse
import com.example.falconHunt.data.model.TokenApiResponse
import com.example.falconHunt.data.model.VehiclesApiResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface Service {
    @Headers("Accept: application/json")
    @POST("/token")
    fun getToken(): Single<TokenApiResponse>

    @GET("/planets")
    fun getPlanets(): Single<List<PlanetsApiResponse>>

    @GET("/vehicles")
    fun getVehicles(): Single<List<VehiclesApiResponse>>

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @POST("/find")
    fun findPrinces(@Body body: FindApiRequest): Single<FindApiResponse>
}