package com.mertyigit0.timecapsule.domain

import androidx.lifecycle.LiveData
import com.mertyigit0.timecapsule.data.Capsule
import com.mertyigit0.timecapsule.data.CapsuleDao
import javax.inject.Inject

class CapsuleRepository @Inject constructor(private val capsuleDao: CapsuleDao) {

    val allCapsules: LiveData<List<Capsule>> = capsuleDao.getAllCapsules()

    suspend fun insert(capsule: Capsule) {
        capsuleDao.insertCapsule(capsule)
    }

    suspend fun delete(id: Int) {
        capsuleDao.deleteCapsule(id)
    }
}
