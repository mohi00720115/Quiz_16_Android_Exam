package com.example.quiz_16_android_exam.ui.first

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz_16_android_exam.data.model.network.repository.MovieData
import com.example.quiz_16_android_exam.data.model.network.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val movieList = MutableLiveData<MovieData>()
    val searchList = MutableLiveData<MovieData>()
    var pages = 1

//    val listMovie = mutableListOf<MovieData>()

    fun getMovieList(page: Int) {
        viewModelScope.launch {
            try {
//                listMovie.addAll(listOf(repository.getPopularMovie(page)))
                pages++
                movieList.postValue(repository.getPopularMovie(page))
            } catch (e: Exception) {
                Log.e(TAG, "getMovieList: ")
            }
        }
    }

    fun nextPage() {
        getMovieList(pages)
    }


}