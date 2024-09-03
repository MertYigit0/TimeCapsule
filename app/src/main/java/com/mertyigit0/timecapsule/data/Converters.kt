package com.mertyigit0.timecapsule.data

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromString(value: String): List<String> {
        return value.split(",").map { it }
    }

    @TypeConverter
    fun listToString(list: List<String>): String {
        return list.joinToString(",")
    }
}
