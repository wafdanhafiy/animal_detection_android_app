package com.tugasakhir.animaldetection.di

import android.content.Context
import com.tugasakhir.animaldetection.data.AnimalDetectionRepository
import com.tugasakhir.animaldetection.data.source.remote.RemoteDataSource
import com.tugasakhir.animaldetection.utils.JsonHelper

object Injection {
    fun provideAnimalDetectionRepository(context: Context): AnimalDetectionRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return AnimalDetectionRepository.getInstance(remoteDataSource)
    }
}