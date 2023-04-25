package com.example.quiz_16_android_exam.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.quiz_16_android_exam.MovieAdapter
import com.example.quiz_16_android_exam.R
import com.example.quiz_16_android_exam.databinding.ActivityMainBinding
import com.example.quiz_16_android_exam.ui.first.FirstViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var movieListAdapter: MovieAdapter
    private val viewModel: FirstViewModel by viewModels()
    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setBottomNavigation()

    }

    /**
     * ساخت باتم نویگیشن ویو
     */
    private fun setBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container_view_activityMain) as NavHostFragment
        navController = navHostFragment.navController
        bottomNavigationView = binding.bottomNavigationActivityMain
        setupWithNavController(bottomNavigationView, navController)
    }

}
