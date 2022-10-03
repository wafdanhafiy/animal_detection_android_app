package com.tugasakhir.animaldetection.ui.detections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetectionsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is scan Fragment"
    }
    val text: LiveData<String> = _text
}