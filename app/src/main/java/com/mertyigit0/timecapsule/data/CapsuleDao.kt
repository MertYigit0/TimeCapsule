package com.mertyigit0.timecapsule.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CapsuleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCapsule(capsule: Capsule)

    @Query("SELECT * FROM capsules WHERE id = :id")
    suspend fun getCapsuleById(id: Int): Capsule?

    @Query("SELECT * FROM capsules")
    fun getAllCapsules(): LiveData<List<Capsule>>

    @Delete
    suspend fun deleteCapsule(capsule: Capsule)
}
