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
    var rotationScale = 0.0f
    var zekrTurn = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSebhaBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.imgSebha.setOnClickListener { sebhaImplemention() }
    }

    private fun sebhaImplemention() {
        Constants.counter++
        rotationScale += 3.6f
        viewBinding.tvSebhaText.text = Constants.zekr[zekrTurn]
        viewBinding.tvSebhaNum.text = "${Constants.counter}"
        viewBinding.imgSebha.rotation = rotationScale
        if (Constants.counter % 33 == 0) zekrTurn++
        if (Constants.counter == 100) resetSebha()
    }

    private fun resetSebha() {
        Constants.counter = 0
        rotationScale = 0.0f
        zekrTurn = 0
    }
}