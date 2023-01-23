package com.banklannister.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.banklannister.cinema.adapter.ViewPagerAdapter
import com.banklannister.cinema.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        with(binding) {
            viewPager.adapter = viewPagerAdapter


            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when(position){
                    0 -> tab.text = "Movie"
                    1 -> tab.text = "TV"
                }
            }.attach()

        }
    }
}