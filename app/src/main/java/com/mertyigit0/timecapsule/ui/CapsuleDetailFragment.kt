package com.mertyigit0.timecapsule.ui

import PhotoAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.mertyigit0.timecapsule.R


class CapsuleDetailFragment : Fragment() {

    private lateinit var photoAdapter: PhotoAdapter
    private val photos = listOf("url1", "url2", "url3") // Fotoğraf URL'lerini buraya ekleyin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_capsule_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager)
        photoAdapter = PhotoAdapter(photos)
        viewPager.adapter = photoAdapter
    }


}