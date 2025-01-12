package com.ae.islami.home.tabs.hadith.details

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ae.islami.databinding.ActivityHadithDetailesBinding
import com.ae.islami.models.Hadith
import java.io.BufferedReader
import java.io.InputStreamReader

class HadithDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHadithDetailesBinding

    lateinit var hadithDetail: List<Hadith>
    var numOfHadith: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadithDetailesBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initView()
    }

    private fun initView() {
        numOfHadith = intent.getIntExtra("numOfHadith", 1)
        openFile(numOfHadith)

        viewBinding.appbar.setNavigationOnClickListener { finish() }
        viewBinding.appbar.title = "Hadith $numOfHadith"
        viewBinding.tvName.text = hadithDetail.first().name
        viewBinding.tvHadith.text = hadithDetail.first().content
    }

    private fun openFile(numOfHadith: Int) {
        val inputStream = assets.open("hadith/h$numOfHadith.txt")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val name = buffer.readLine()
        hadithDetail = listOf(
            Hadith(
                name = name,
                content = buffer.readLine(),
            )
        )
        buffer.forEachLine {
            if (!it.equals(null)) {
                hadithDetail = listOf(
                    Hadith(
                        name = name,
                        content = "${hadithDetail.first().content} \n $it"
                    )
                )
            }
        }
    }
}