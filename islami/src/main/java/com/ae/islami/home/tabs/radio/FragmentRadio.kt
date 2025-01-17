package com.ae.islami.home.tabs.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ae.islami.databinding.FragmentRadioBinding

class FragmentRadio : Fragment() {
    lateinit var viewBinding: FragmentRadioBinding
    lateinit var adapter: RadioAdapter
    val radioName = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentRadioBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createItems()
        adapter = RadioAdapter(radioName)
        viewBinding.rvRadio.adapter = adapter
    }

    private fun createItems() {
        for (i in 0..6) {
            radioName.add("Ahmed Ebrahim [${i + 1}]")
        }
    }

}