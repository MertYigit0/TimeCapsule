package com.mertyigit0.timecapsule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.mertyigit0.timecapsule.data.Capsule
import com.mertyigit0.timecapsule.databinding.FragmentCreateCapsuleBinding
import com.mertyigit0.timecapsule.ui.CapsuleViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CreateCapsuleFragment : Fragment(R.layout.fragment_create_capsule) {

    private lateinit var binding: FragmentCreateCapsuleBinding
    private val capsuleViewModel: CapsuleViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateCapsuleBinding.bind(view)

        binding.buttonSave.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val note = binding.editTextNote.text.toString()
            val photos = listOf<String>() // Photo handling can be expanded
            val creationTime = System.currentTimeMillis()
            val openingTime = System.currentTimeMillis() + (24 * 60 * 60 * 1000) // Example: 1 day later

            if (name.isNotEmpty() && note.isNotEmpty()) {
                val capsule = Capsule(
                    name = name,
                    note = note,
                    photos = photos,
                    creationTime = creationTime,
                    openingTime = openingTime
                )
                capsuleViewModel.insert(capsule)
                Toast.makeText(context, "Capsule created!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
