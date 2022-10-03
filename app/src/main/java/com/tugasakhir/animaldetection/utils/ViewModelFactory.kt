package com.tugasakhir.animaldetection.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tugasakhir.animaldetection.data.AnimalDetectionRepository
import com.tugasakhir.animaldetection.di.Injection
import com.tugasakhir.animaldetection.ui.article.ArticlesViewModel
import com.tugasakhir.animaldetection.ui.datalist.DataViewModel

class ViewModelFactory private constructor(private val mAnimalDetectionRepository: AnimalDetectionRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideAnimalDetectionRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ArticlesViewModel::class.java) -> {
                return ArticlesViewModel(mAnimalDetectionRepository) as T
            }
            modelClass.isAssignableFrom(DataViewModel::class.java) -> {
                return DataViewModel(mAnimalDetectionRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}