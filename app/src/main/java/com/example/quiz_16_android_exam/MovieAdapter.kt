package com.example.quiz_16_android_exam

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quiz_16_android_exam.data.model.network.repository.MovieData
import com.example.quiz_16_android_exam.databinding.ItemMoviesBinding

class MovieAdapter : ListAdapter<MovieData, MovieAdapter.ViewHolder>(DiffCallback()) {
    class DiffCallback : DiffUtil.ItemCallback<MovieData>() {
        override fun areItemsTheSame(oldItem: MovieData, newItem: MovieData): Boolean =
            oldItem.page == newItem.page

        override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData): Boolean =
            oldItem == newItem
    }

    inner class ViewHolder(private val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MovieData) {
            Log.e(TAG, "Movie Adapter: page ${item.page}")
            Log.e(TAG, "Movie Adapter: results ${item.results}")
            Log.e(TAG, "Movie Adapter: total_pages ${item.total_pages}")
            Log.e(TAG, "Movie Adapter: total_results ${item.total_results}")

            binding.tvName.text = item.results.toString()
            binding.tvTitle.text = item.page.toString()
            binding.tvDescription.text = item.total_pages.toString()

            Glide.with(binding.root)
                .load(item.results)
//                .placeholder(R.drawable.loading_animation)
                .into(binding.imageViewMovie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

}