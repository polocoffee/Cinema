package com.banklannister.cinema.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.banklannister.cinema.Extensions.EXTRA_TVS
import com.banklannister.cinema.Extensions.IMAGE_BASE
import com.banklannister.cinema.databinding.ActivityDetailTvBinding
import com.banklannister.cinema.models.TV
import com.bumptech.glide.Glide

class DetailTvActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTvBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.imgDetailTv.clipToOutline = true

        val detailTVs = intent.getParcelableExtra<TV>(EXTRA_TVS)

        if (detailTVs != null) {
            Glide.with(this).load(IMAGE_BASE + detailTVs.poster).into(binding.imgDetailTv)
            binding.tvDetailTvName.text = detailTVs.title
            binding.tvDetailTvDesc.text = detailTVs.overview
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}