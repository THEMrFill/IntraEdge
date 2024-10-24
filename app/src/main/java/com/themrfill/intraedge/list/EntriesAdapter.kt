package com.themrfill.intraedge.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.themrfill.intraedge.databinding.EntriesRowBinding

class EntriesAdapter: RecyclerView.Adapter<EntriesViewHolder>() {
    private val entries = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntriesViewHolder {
        val binding = EntriesRowBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return EntriesViewHolder(binding)
    }

    override fun getItemCount(): Int = entries.size

    override fun onBindViewHolder(holder: EntriesViewHolder, position: Int) {
        holder.bind(entries[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newEntries: ArrayList<String>) {
        entries.clear()
        entries.addAll(newEntries)
        notifyDataSetChanged()
    }

    fun addEntry(entry: String) {
        entries.add(0, entry)
        notifyItemInserted(0)
    }
}

class EntriesViewHolder(val binding: EntriesRowBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(entry: String) {
        binding.entry.text = entry
    }
}