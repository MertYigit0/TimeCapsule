package com.mertyigit0.timecapsule.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CapsuleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(capsule: Capsule)

    @Query("SELECT * FROM capsules")
    fun getAllCapsules(): LiveData<List<Capsule>>

    @Query("DELETE FROM capsules WHERE id = :id")
    suspend fun delete(id: Int)  // id'yi Long veya kapsülün id türü ile eşleştirin
}
