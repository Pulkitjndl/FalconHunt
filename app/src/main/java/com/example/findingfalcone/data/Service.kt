package com.example.findingfalcone.data

import com.example.findingfalcone.data.model.FindApiRequest
import com.example.findingfalcone.data.model.FindApiResponse
import com.example.findingfalcone.data.model.PlanetApiResponse
import com.example.findingfalcone.data.model.TokenApiResponse
import com.example.findingfalcone.data.model.VehiclesApiResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {
    @GET("/token")
    fun getToken(): Single<TokenApiResponse>

    @GET("/planets")
    fun getPlanets(): Single<List<PlanetApiResponse>>

    @GET("/vehicles")
    fun getVehicles(): Single<List<VehiclesApiResponse>>

    @POST("/find")
    fun findPrinces(@Body body: FindApiRequest): Single<FindApiResponse>
}