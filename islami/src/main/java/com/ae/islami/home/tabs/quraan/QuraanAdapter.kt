package com.ae.islami.home.tabs.quraan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getString
import androidx.recyclerview.widget.RecyclerView
import com.ae.islami.R
import com.ae.islami.databinding.ItemQuraanContentBinding
import com.ae.islami.models.Sura

class QuraanAdapter(val listOfSuaras: List<Sura>) :
    RecyclerView.Adapter<QuraanAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemQuraanContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = listOfSuaras.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sura = listOfSuaras[position]
        val verses = "${sura.numOfAyat} " + getString(holder.itemView.context, R.string.verses)
        holder.itemViewBinding.tvEn.text = sura.suraByEn
        holder.itemViewBinding.tvAr.text = sura.suraByAR
        holder.itemViewBinding.tvNum.text = "${sura.numOfSura}"
        holder.itemViewBinding.tvVerses.text = verses

        onItemClickListener?.let {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onClickListener(position, sura)
            }
        }

    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onClickListener(position: Int, item: Sura)
    }

    class ViewHolder(val itemViewBinding: ItemQuraanContentBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root)
}