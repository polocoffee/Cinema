package com.banklannister.cinema.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.banklannister.cinema.adapter.TVAdapter
import com.banklannister.cinema.databinding.FragmentTelevisionBinding
import com.banklannister.cinema.models.TV
import com.banklannister.cinema.models.TVResponse
import com.banklannister.cinema.services.TVApiInterface
import com.banklannister.cinema.services.TVApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TelevisionFragment : Fragment() {
    private lateinit var binding: FragmentTelevisionBinding
    private val tv = arrayListOf<TV>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTelevisionBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTvList.layoutManager = LinearLayoutManager(this.context)
        binding.rvTvList.setHasFixedSize(true)

        getTVData { tv: List<TV> ->
            binding.rvTvList.adapter = TVAdapter(tv)

        }
        showRecyclerView()
    }


    private fun getTVData(callback: (List<TV>) -> Unit) {
        val apiService = TVApiService.getInstance().create(TVApiInterface::class.java)
        apiService.getTVList().enqueue(object : Callback<TVResponse> {
            override fun onResponse(call: Call<TVResponse>, response: Response<TVResponse>) {
                return callback(response.body()!!.tv)
            }

            override fun onFailure(call: Call<TVResponse>, t: Throwable) {

            }

        })
    }

    private fun showRecyclerView() {
        binding.rvTvList.layoutManager = LinearLayoutManager(this.context)
        binding.rvTvList.adapter = TVAdapter(tv)
    }

}