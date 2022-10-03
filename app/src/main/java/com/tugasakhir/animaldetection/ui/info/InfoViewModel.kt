package com.tugasakhir.animaldetection.ui.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InfoViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "AnimalDetection adalah aplikasi untuk deteksi hewan menggunakan Convolutional Neural Network."
    }
    val text: LiveData<String> = _text
}