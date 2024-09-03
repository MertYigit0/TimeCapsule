package com.mertyigit0.timecapsule

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mertyigit0.timecapsule.data.Capsule
import com.mertyigit0.timecapsule.databinding.FragmentCreateCapsuleBinding
import com.mertyigit0.timecapsule.ui.CapsuleViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar


@AndroidEntryPoint
class CreateCapsuleFragment : Fragment(R.layout.fragment_create_capsule) {

    private lateinit var binding: FragmentCreateCapsuleBinding
    private val capsuleViewModel: CapsuleViewModel by viewModels()

    private var selectedOpeningTime: Long = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateCapsuleBinding.bind(view)

        // Takvim ikonu tıklama olayını ekleyin
        binding.imageViewCalendar.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(requireContext(),
                { _, selectedYear, selectedMonth, selectedDay ->
                    val calendar = Calendar.getInstance()
                    calendar.set(selectedYear, selectedMonth, selectedDay)
                    selectedOpeningTime = calendar.timeInMillis
                    val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    binding.editTextDate.setText(selectedDate)
                }, year, month, day)

            datePickerDialog.show()
        }

        binding.buttonSave.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val note = binding.editTextNote.text.toString()
            val photos = listOf<String>() // Fotoğraf işleme buradan genişletilebilir
            val creationTime = System.currentTimeMillis()

            if (name.isNotEmpty() && note.isNotEmpty() && selectedOpeningTime != 0L) {
                val capsule = Capsule(
                    name = name,
                    note = note,
                    photos = photos,
                    creationTime = creationTime,
                    openingTime = selectedOpeningTime
                )
                capsuleViewModel.insert(capsule)
                Toast.makeText(context, "Capsule created!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Please fill in all fields!", Toast.LENGTH_SHORT).show()
            }
        }

        // Go Home Button
        binding.buttonGoHome.setOnClickListener {
            goHome()
        }
    }

    private fun goHome() {
        findNavController().navigate(R.id.action_createCapsuleFragment_to_homeFragment)
    }
}

