package com.mertyigit0.timecapsule.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "capsules")
data class Capsule(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val photos: List<String>,  // Fotoğraf URL'lerini saklamak için
    val audio: String?,  // Ses kaydının dosya yolu
    val text: String,
    val openDate: Long  // Tarih millisaniye cinsinden
)
