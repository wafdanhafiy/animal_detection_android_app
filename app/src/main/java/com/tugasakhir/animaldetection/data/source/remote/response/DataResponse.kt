package com.tugasakhir.animaldetection.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataResponse (
    val id: String,
    val title: String,
    val deskripsi1: String,
    val deskripsi2: String,
    val deskripsi3: String,
    val imgPath: String
):Parcelable