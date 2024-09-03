package com.mertyigit0.timecapsule.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mertyigit0.timecapsule.data.Capsule
import com.mertyigit0.timecapsule.domain.CapsuleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CapsuleViewModel @Inject constructor(private val repository: CapsuleRepository) : ViewModel() {

    val allCapsules: LiveData<List<Capsule>> = repository.allCapsules

    fun insert(capsule: Capsule) = viewModelScope.launch {
        repository.insert(capsule)
    }

    fun delete(id: Int) = viewModelScope.launch {
        repository.delete(id)
    }
}

