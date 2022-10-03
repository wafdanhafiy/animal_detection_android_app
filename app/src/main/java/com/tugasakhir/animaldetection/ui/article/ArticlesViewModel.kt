package com.tugasakhir.animaldetection.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tugasakhir.animaldetection.data.AnimalDetectionRepository
import com.tugasakhir.animaldetection.data.source.local.entity.ArticleEntity

class ArticlesViewModel(private val AnimalDetectionRepository: AnimalDetectionRepository) : ViewModel() {

    fun resultArticle(): LiveData<List<ArticleEntity>> = AnimalDetectionRepository.getAllArticles()
}