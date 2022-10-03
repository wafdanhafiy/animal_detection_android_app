package com.tugasakhir.animaldetection.data

import androidx.lifecycle.LiveData
import com.tugasakhir.animaldetection.data.source.local.entity.ArticleEntity
import com.tugasakhir.animaldetection.data.source.local.entity.DataEntity


interface IAnimalDetectionRepository {
    fun getAllArticles(): LiveData<List<ArticleEntity>>
    fun getAllData(): LiveData<List<DataEntity>>
}