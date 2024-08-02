package com.mertyigit0.timecapsule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mertyigit0.timecapsule.util.Converters


@Database(entities = [Capsule::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CapsuleDatabase : RoomDatabase() {
    abstract fun capsuleDao(): CapsuleDao

    companion object {
        @Volatile
        private var INSTANCE: CapsuleDatabase? = null

        fun getDatabase(context: Context): CapsuleDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CapsuleDatabase::class.java,
                    "capsule_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
