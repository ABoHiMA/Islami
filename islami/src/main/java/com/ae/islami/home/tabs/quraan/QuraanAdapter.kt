package com.ae.islami.home.tabs.quraan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getString
import androidx.recyclerview.widget.RecyclerView
import com.ae.islami.R
import com.ae.islami.databinding.ItemQuraanContentBinding
import com.ae.islami.models.Sura
import java.util.Locale

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
        holder.bindData(sura)
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
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bindData(sura: Sura) {
            val verses = "${sura.numOfAyat} " + getString(itemView.context, R.string.verses)
            val lang = Locale.getDefault().language
            val engText = if (lang.equals("en")) {
                sura.suraByEn
            } else {
                sura.suraByAR
            }
            val arText = if (lang.equals("en")) {
                sura.suraByAR
            } else {
                sura.suraByEn
            }
            itemViewBinding.tvEn.text = engText
            itemViewBinding.tvAr.text = arText
            itemViewBinding.tvNum.text = "${sura.numOfSura}"
            itemViewBinding.tvVerses.text = verses
        }
    }
}