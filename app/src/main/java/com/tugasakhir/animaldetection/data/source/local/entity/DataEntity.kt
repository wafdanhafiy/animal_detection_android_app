package com.tugasakhir.animaldetection.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "tb_data")
@Parcelize
data class DataEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "deskripsi1")
    val deskripsi1: String,

    @ColumnInfo(name = "deskripsi2")
    val deskripsi2: String,

    @ColumnInfo(name = "deskripsi3")
    val deskripsi3: String,

    @ColumnInfo(name = "imgPath")
    val imgPath: String
) : Parcelable