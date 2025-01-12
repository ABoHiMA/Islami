package com.ae.islami.home.tabs.quraan.sura

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ae.islami.databinding.ItemSuraDetailsContentBinding
import com.ae.islami.models.SuraDetails

class SuraDetailsAdapter(val listOfSuraDetails: List<SuraDetails>) :
    RecyclerView.Adapter<SuraDetailsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSuraDetailsContentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listOfSuraDetails.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sura = listOfSuraDetails[position]
        val ayah = "[${sura.numOfAyah}] ${sura.textOfAyah}"
        holder.itemViewBinding.tvAyah.text = ayah
    }

    class ViewHolder(val itemViewBinding: ItemSuraDetailsContentBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root)
}