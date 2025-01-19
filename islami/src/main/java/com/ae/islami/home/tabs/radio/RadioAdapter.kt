package com.ae.islami.home.tabs.radio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ae.islami.R
import com.ae.islami.databinding.ItemRadioContentBinding

class RadioAdapter(val listOfRadioName: List<String>) :
    RecyclerView.Adapter<RadioAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemRadioContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = listOfRadioName.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.dataBinding(listOfRadioName, position)

    class ViewHolder(private val itemViewBinding: ItemRadioContentBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun dataBinding(listOfRadioName: List<String>, position: Int) {
            var isPlay = false
            var isSound = false

            itemViewBinding.tvRadioName.text = listOfRadioName[position]

            itemViewBinding.icPlay.setOnClickListener {
                if (!isPlay) {
                    itemViewBinding.icPlay.setImageResource(R.drawable.ic_pause)
                    isPlay = true
                } else {
                    itemViewBinding.icPlay.setImageResource(R.drawable.ic_play)
                    isPlay = false
                }
            }

            itemViewBinding.icSound.setOnClickListener {
                if (!isSound) {
                    itemViewBinding.icSound.setImageResource(R.drawable.ic_mute)
                    isSound = true
                } else {
                    itemViewBinding.icSound.setImageResource(R.drawable.ic_sound)
                    isSound = false
                }
            }

        }
    }

}