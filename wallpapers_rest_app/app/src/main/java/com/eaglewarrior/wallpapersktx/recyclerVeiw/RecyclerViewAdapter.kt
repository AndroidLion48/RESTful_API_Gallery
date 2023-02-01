package com.eaglewarrior.wallpapersktx.recyclerVeiw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.eaglewarrior.wallpapersktx.R
import com.eaglewarrior.wallpapersktx.databinding.ItemRecyclerViewBinding
import com.eaglewarrior.wallpapersktx.model.Data

/**
 * Created by Clarence E Moore on 2023-01-27.
 *
 * Description:
 *
 *
 */
class RecyclerViewAdapter : PagingDataAdapter<Data, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallback()) {
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemRecyclerViewBinding.bind(view)

        fun bind(data: Data) {
            // Glide
            Glide.with(itemView.context)
                .asBitmap()
                .load(data.smallImageUrl)
                .centerCrop()
                .transition(BitmapTransitionOptions.withCrossFade(80))
                .error(R.drawable.ic_baseline_error_24)
                .into(binding.imageView)
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return MyViewHolder(inflater)
    }

    class DiffUtilCallback: DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
             return oldItem.blurHash == newItem.blurHash
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }
}
