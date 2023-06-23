package com.hasancbngl.herocomposeapp.data.remote

import com.hasancbngl.herocomposeapp.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroApi {

    @GET("/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse
}