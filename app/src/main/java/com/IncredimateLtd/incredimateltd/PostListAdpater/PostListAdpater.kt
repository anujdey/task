package com.IncredimateLtd.incredimateltd.PostListAdpater


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.IncredimateLtd.incredimateltd.Response.PostsResponseItem
import com.IncredimateLtd.incredimateltd.databinding.NewdashboardBinding

class PostListAdpater: RecyclerView.Adapter<PostListAdpater.ViewHolder>() {

    private var originalList: MutableList<PostsResponseItem> = mutableListOf()

    inner class ViewHolder(val binding: NewdashboardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            NewdashboardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostListAdpater.ViewHolder, position: Int) {
        with(holder.binding) {
             idnumber.text=originalList[position].id.toString()
             uerid.text=originalList[position].userId.toString()
             title.text=originalList[position].title
             body.text=originalList[position].body

        }

    }



    override fun getItemCount(): Int {
        return originalList.size
    }

    fun setData(newList: MutableList<PostsResponseItem>) {
        originalList = newList
        notifyDataSetChanged()
    }
}