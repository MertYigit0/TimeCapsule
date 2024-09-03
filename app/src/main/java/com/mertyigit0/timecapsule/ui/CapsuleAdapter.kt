package com.mertyigit0.timecapsule.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mertyigit0.timecapsule.R
import com.mertyigit0.timecapsule.data.Capsule

class CapsuleAdapter : ListAdapter<Capsule, CapsuleAdapter.CapsuleViewHolder>(CapsuleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CapsuleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.capsule_item, parent, false)
        return CapsuleViewHolder(view)
    }

    override fun onBindViewHolder(holder: CapsuleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CapsuleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        private val textViewNote: TextView = itemView.findViewById(R.id.textViewNote)

        fun bind(capsule: Capsule) {
            textViewName.text = capsule.name
            textViewNote.text = capsule.note
            // Diğer veriler de burada bağlanabilir
        }
    }

    class CapsuleDiffCallback : DiffUtil.ItemCallback<Capsule>() {
        override fun areItemsTheSame(oldItem: Capsule, newItem: Capsule): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Capsule, newItem: Capsule): Boolean {
            return oldItem == newItem
        }
    }
}

