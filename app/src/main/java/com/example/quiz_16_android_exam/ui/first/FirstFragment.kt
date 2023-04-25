package com.example.quiz_16_android_exam.ui.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.quiz_16_android_exam.MovieAdapter
import com.example.quiz_16_android_exam.R
import com.example.quiz_16_android_exam.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var binding : FragmentFirstBinding
    private lateinit var movieListAdapter: MovieAdapter
    private val viewModel: FirstViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        movieListAdapter = MovieAdapter()
        viewModel.getMovieList(10)
        binding.recyclerViewFirst.adapter = movieListAdapter

        viewModel.movieList.observe(viewLifecycleOwner) {
//                list ->
//            Log.e(TAG, "onCreate: $list")
//            movieListAdapter.submitList(it?.results ?: emptyList())
        }


    }

}