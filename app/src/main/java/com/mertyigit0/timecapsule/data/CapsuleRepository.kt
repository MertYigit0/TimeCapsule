package com.mertyigit0.timecapsule.data

import androidx.lifecycle.LiveData
import javax.inject.Inject

class CapsuleRepository @Inject constructor(private val capsuleDao: CapsuleDao) {
    val allCapsules: LiveData<List<Capsule>> = capsuleDao.getAllCapsules()

    suspend fun insert(capsule: Capsule) {
        capsuleDao.insertCapsule(capsule)
    }

    suspend fun getCapsuleById(id: Int): Capsule? {
        return capsuleDao.getCapsuleById(id)
    }

    suspend fun delete(capsule: Capsule) {
        capsuleDao.deleteCapsule(capsule)
    }
}
