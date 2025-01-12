package com.ae.islami.home.tabs.quraan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ae.islami.components.Constants
import com.ae.islami.databinding.FragmentQuraanBinding
import com.ae.islami.home.tabs.quraan.sura.SuraDetailsActivity


class FragmentQuraan : Fragment() {
    lateinit var viewBinding: FragmentQuraanBinding
    lateinit var adapter: QuraanAdapter
    val sura = Constants.getSuras()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentQuraanBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = QuraanAdapter(sura)
        adapter.onItemClickListener = QuraanAdapter.OnItemClickListener { position, item ->
            navigateToSura(position)
        }

        viewBinding.rvQuraan.adapter = adapter
    }

    private fun navigateToSura(position: Int) {
        val intent = Intent(activity, SuraDetailsActivity::class.java)
        intent.putExtra("numOfSura", sura[position].numOfSura)
        intent.putExtra("suraByAR", sura[position].suraByAR)
        intent.putExtra("suraByEn", sura[position].suraByEn)
        startActivity(intent)
    }
}