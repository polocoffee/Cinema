package com.banklannister.cinema.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.banklannister.cinema.Extensions.EXTRA_TVS
import com.banklannister.cinema.Extensions.IMAGE_BASE
import com.banklannister.cinema.databinding.TvItemBinding
import com.banklannister.cinema.models.TV
import com.banklannister.cinema.ui.DetailTvActivity
import com.bumptech.glide.Glide

class TVAdapter(private val tvs: List<TV>) :
    RecyclerView.Adapter<TVAdapter.TVViewHolder>() {

    class TVViewHolder(private val itemBinding: TvItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindTv(tv: TV) {
            itemBinding.apply {
                textTvTitleCardView.text = tv.title
                textTvDesc.text = tv.overview
                Glide.with(imgTvCardView).load(IMAGE_BASE + tv.poster)
                    .into(imgTvCardView)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVViewHolder {
        val itemBinding = TvItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TVViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: TVViewHolder, position: Int) {
        val tv = tvs[position]
        holder.bindTv(tvs[position])

        holder.itemView.setOnClickListener {
            moveToTVDetail(tv, it)
        }

    }

    override fun getItemCount(): Int = tvs.size

    private fun moveToTVDetail(tv: TV, it: View) {
        val detailTVIntent = Intent(it.context, DetailTvActivity::class.java)
        detailTVIntent.putExtra(EXTRA_TVS, tv)
        it.context.startActivity(detailTVIntent)
    }
}





