package com.tugasakhir.animaldetection.ui.datalist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tugasakhir.animaldetection.data.AnimalDetectionRepository
import com.tugasakhir.animaldetection.data.source.local.entity.DataEntity

class DataViewModel(private val AnimalDetectionRepository: AnimalDetectionRepository) : ViewModel() {


    fun resultData(): LiveData<List<DataEntity>> = AnimalDetectionRepository.getAllData()
}