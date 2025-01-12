package com.ae.islami.home.tabs.hadith

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ae.islami.databinding.FragmentHadithBinding
import com.ae.islami.home.tabs.hadith.details.HadithDetailsActivity
import com.ae.islami.models.Hadith
import java.io.BufferedReader
import java.io.InputStreamReader

class FragmentHadith : Fragment() {
    lateinit var viewBinding: FragmentHadithBinding
    lateinit var adapter: HadithAdapter
    val hadith = mutableListOf<Hadith>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHadithBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createItems()
        adapter = HadithAdapter(hadith)
        adapter.onItemClickListener = HadithAdapter.OnItemClickListener { position, hadith -> navigateToHadithDetails(position+1) }
        viewBinding.rvHadith.adapter = adapter
    }

    private fun navigateToHadithDetails(numOfHadith: Int) {
        val intent = Intent(activity, HadithDetailsActivity::class.java)
        intent.putExtra("numOfHadith", numOfHadith)
        startActivity(intent)
    }

    private fun createItems() {
        for (i in 1..50) {
            openFile(i)
        }
    }

    private fun openFile(numOfHadith: Int) {
        val inputStream = activity?.assets?.open("hadith/h$numOfHadith.txt")
        val buffer = BufferedReader(InputStreamReader(inputStream))

        val name = buffer.readLine()
        val firstLine = buffer.readLine()
        val secondLine = buffer.readLine()
        val content = if (secondLine != null) {
            "$firstLine \n $secondLine"
        } else {
            firstLine
        }

        hadith.add(
            Hadith(
                name = name,
                content = content
            )
        )
    }
}