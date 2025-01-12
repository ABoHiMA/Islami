package com.ae.islami.home.tabs.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ae.islami.components.Constants
import com.ae.islami.databinding.FragmentSebhaBinding

class FragmentSebha : Fragment() {
    lateinit var viewBinding: FragmentSebhaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSebhaBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.tvSebhaNum.text = "${Constants.counter}"
        viewBinding.imgSebha.setOnClickListener {
            Constants.counter++
            viewBinding.tvSebhaNum.text = "${Constants.counter}"
        }
        
    }
}