package com.mertyigit0.timecapsule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mertyigit0.timecapsule.data.Capsule
import com.mertyigit0.timecapsule.data.CapsuleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CapsuleViewModel @Inject constructor(
    private val repository: CapsuleRepository
) : ViewModel() {

    val capsules = repository.getAllCapsules()

    fun insert(capsule: Capsule) = viewModelScope.launch {
        repository.insert(capsule)
    }

    fun delete(capsule: Capsule) = viewModelScope.launch {
        repository.delete(capsule)  // Bu, repository'de id'yi kullanarak delete metodunu çağırır
    }
}
