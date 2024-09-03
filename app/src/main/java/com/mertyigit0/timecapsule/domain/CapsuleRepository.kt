package com.mertyigit0.timecapsule.data

import javax.inject.Inject

class CapsuleRepository @Inject constructor(
    private val capsuleDao: CapsuleDao
) {
    fun getAllCapsules() = capsuleDao.getAllCapsules()

    suspend fun insert(capsule: Capsule) {
        capsuleDao.insert(capsule)
    }

    suspend fun delete(capsule: Capsule) {
        capsuleDao.delete(capsule.id)  // id'yi kullanarak silme işlemi
    }
}
