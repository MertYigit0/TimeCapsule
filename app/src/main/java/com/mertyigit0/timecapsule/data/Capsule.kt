package com.mertyigit0.timecapsule.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.concurrent.TimeUnit

@Entity(tableName = "capsules")
data class Capsule(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val note: String,
    val photos: List<String>, // Fotoğrafları depolamak için bir String listesi
    val creationTime: Long, // Oluşturulma zamanı, Unix timestamp olarak
    val openingTime: Long // Açılacağı zaman, Unix timestamp olarak
)


