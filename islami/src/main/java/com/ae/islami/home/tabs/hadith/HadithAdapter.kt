package com.ae.islami.home.tabs.hadith

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ae.islami.databinding.ItemHadithContentBinding
import com.ae.islami.models.Hadith

class HadithAdapter(val listOfHadith: List<Hadith>) :
    RecyclerView.Adapter<HadithAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemHadithContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = listOfHadith.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadith = listOfHadith[position]
        holder.itemViewBinding.tvName.text = hadith.name
        holder.itemViewBinding.tvHadith.text = hadith.content

        onItemClickListener?.let {
            holder.itemViewBinding.card.setOnClickListener {
                onItemClickListener?.onClick(position, hadith)
            }
        }
    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onClick(position: Int, hadith: Hadith)
    }

    class ViewHolder(val itemViewBinding: ItemHadithContentBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root)

}