package com.IncredimateLtd.incredimateltd

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.IncredimateLtd.incredimateltd.BaseActivity.BaseActivtiy
import com.IncredimateLtd.incredimateltd.PostListAdpater.PostListAdpater
import com.IncredimateLtd.incredimateltd.Response.PostsResponse
import com.IncredimateLtd.incredimateltd.Response.PostsResponseItem
import com.IncredimateLtd.incredimateltd.RetrofitClient.RetrofitClient
import com.IncredimateLtd.incredimateltd.Util.toast
import com.IncredimateLtd.incredimateltd.databinding.ActivityMainBinding

class MainActivity : BaseActivtiy() {

    lateinit var binding: ActivityMainBinding
    private var oldList: MutableList<PostsResponseItem> = mutableListOf()
    private lateinit var adapter: PostListAdpater
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = PostListAdpater()

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter
            recyclerView.hasFixedSize()
        }

        hitApi()

    }


    override fun onResume() {
        super.onResume()
        hitApi()
    }

    private fun hitApi() {
        oldList.clear()
        callApi(RetrofitClient().getposts()) { response ->
            if (response is PostsResponse) {
                if (response.isNotEmpty()) {
                    val data = response
                    oldList.addAll(data)
                    adapter.setData(oldList)
                } else {
                    toast("No data Found")
                }

            } else {
                toast("Error: Unable to fetch data")
            }
        }

    }


}