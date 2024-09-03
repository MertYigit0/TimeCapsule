package com.mertyigit0.timecapsule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mertyigit0.timecapsule.data.Capsule
import com.mertyigit0.timecapsule.databinding.FragmentHomeBinding
import com.mertyigit0.timecapsule.ui.CapsuleAdapter
import com.mertyigit0.timecapsule.ui.CapsuleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val capsuleViewModel: CapsuleViewModel by viewModels()
    private lateinit var capsuleAdapter: CapsuleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerView ve Adapter'ı ayarlayın
        setupRecyclerView()

        // LiveData'dan verileri gözlemleyin ve adapter'a iletin
        capsuleViewModel.capsules.observe(viewLifecycleOwner) { capsules ->
            capsuleAdapter.submitList(capsules)
        }
    }

    private fun setupRecyclerView() {
        capsuleAdapter = CapsuleAdapter { capsule ->
            showDeleteDialog(capsule)
        }
        binding.recyclerviewCapsule.apply {
            adapter = capsuleAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun showDeleteDialog(capsule: Capsule) {
        AlertDialog.Builder(requireContext())
            .setTitle("Delete Capsule")
            .setMessage("Are you sure you want to delete this capsule?")
            .setPositiveButton("Yes") { _, _ ->
                capsuleViewModel.delete(capsule)
            }
            .setNegativeButton("No", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
