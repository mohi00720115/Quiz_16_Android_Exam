package com.example.quiz_16_android_exam.di

import com.example.quiz_16_android_exam.data.model.network.repository.MovieData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//    @Provides
//    @Singleton
//    fun provideInterceptor(): Interceptor = Interceptor { chain ->
//        val url = chain.request()
//            .url
//            .newBuilder()
////            .addQueryParameter("per_page", MovieData.PER_PAGE)
//            .build()
//        val request = chain.request()
//            .newBuilder()
//            .url(url)
//            .build()
//        chain.proceed(request)
//    }

//    @Provides
//    @Singleton
//    fun provideOkkHttpClient(interceptor: Interceptor): OkHttpClient = OkHttpClient.Builder()
//        .addInterceptor(interceptor)
//        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//        .connectTimeout(3, TimeUnit.SECONDS)
//        .build()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideCountryApi(retrofit: Retrofit): MovieData = retrofit.create(MovieData::class.java)

}