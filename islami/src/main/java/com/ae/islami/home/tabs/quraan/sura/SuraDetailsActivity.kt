package com.ae.islami.home.tabs.quraan.sura

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ae.islami.databinding.ActivitySuraDetailsBinding
import com.ae.islami.models.SuraDetails
import java.io.BufferedReader
import java.io.InputStreamReader

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySuraDetailsBinding
    lateinit var adapter: SuraDetailsAdapter
    val suras: MutableList<SuraDetails> = mutableListOf()
    lateinit var suraByEn: String
    lateinit var suraByAR: String
    var numOfSura = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initActivity()
    }

    private fun initActivity() {
        numOfSura = intent.getIntExtra("numOfSura", 1)
        suraByEn = intent.getStringExtra("suraByEn").toString()
        suraByAR = intent.getStringExtra("suraByAR").toString()

        viewBinding.appbar.setNavigationOnClickListener { finish() }
        viewBinding.appbar.title = suraByEn

        viewBinding.tvName.text = suraByAR
        openFile(numOfSura)

        adapter = SuraDetailsAdapter(suras)
        viewBinding.rvAyat.adapter = adapter
    }

    private fun openFile(numOfAyah: Int) {
        var ayahCount = 1
        val inputStream = assets.open("suras/$numOfAyah.txt")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        buffer.forEachLine {
            if (it.isNotEmpty()) suras.add(
                SuraDetails(
                    numOfAyah = ayahCount,
                    textOfAyah = it,
                )
            )
            ayahCount++
        }
    }

}