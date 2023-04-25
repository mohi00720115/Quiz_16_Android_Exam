package com.example.quiz_16_android_exam.data.model.network.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repository @Inject constructor(private val iService: IService) {

    suspend fun getPopularMovie(page: Int): MovieData {
        return withContext(Dispatchers.IO) {
            iService.getAllMovie("api", "language", page)
        }
    }
}