package com.example.quiz_16_android_exam.data.model.network.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IService {

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/"
        const val API_KEY: String = "a447989f2b34e1193b1194c6265c3d3f"
        const val LANGUAGE: String = "en-Us"
        const val PAGE: Int = 1
//        const val PER_PAGE: String = "100"
    }

    @GET("3/movie/popular")
    fun getAllMovie(
        @Query(API_KEY) apiKey: String,
        @Query(LANGUAGE) language: String,
        @Query(PAGE.toString()) page: Int,
    ): MovieData

}