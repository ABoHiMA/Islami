package com.ae.islami.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ae.islami.R
import com.ae.islami.R.drawable.hadeth_bg
import com.ae.islami.R.drawable.quraan_bg
import com.ae.islami.R.drawable.radio_bg
import com.ae.islami.R.drawable.sebha_bg
import com.ae.islami.databinding.ActivityHomeBinding
import com.ae.islami.home.tabs.hadith.FragmentHadith
import com.ae.islami.home.tabs.quraan.FragmentQuraan
import com.ae.islami.home.tabs.radio.FragmentRadio
import com.ae.islami.home.tabs.sebha.FragmentSebha
import java.io.BufferedReader
import java.io.InputStreamReader

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nav.itemActiveIndicatorColor = null
        binding.nav.setOnItemSelectedListener { menu ->
            var fragment: Fragment = FragmentQuraan()
            when (menu.itemId) {
                R.id.item_quraan -> {
                    fragment = FragmentQuraan()
                    binding.mainHome.setBackgroundResource(quraan_bg)
                }

                R.id.item_hadith -> {
                    fragment = FragmentHadith()
                    binding.mainHome.setBackgroundResource(hadeth_bg)
                }

                R.id.item_sebha -> {
                    fragment = FragmentSebha()
                    binding.mainHome.setBackgroundResource(sebha_bg)
                }

                R.id.item_radio -> {
                    fragment = FragmentRadio()
                    binding.mainHome.setBackgroundResource(radio_bg)
                }

                else -> {
                    fragment = FragmentQuraan()
                    binding.mainHome.setBackgroundResource(quraan_bg)
                }
            }
            startFragment(fragment)
            return@setOnItemSelectedListener true
        }
        binding.nav.selectedItemId = R.id.item_quraan
    }

    private fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}
