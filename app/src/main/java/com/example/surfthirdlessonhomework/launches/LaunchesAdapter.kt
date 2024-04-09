package com.example.surfthirdlessonhomework.launches

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.surfthirdlessonhomework.R
import com.example.surfthirdlessonhomework.databinding.LaunchViewBinding
import com.example.surfthirdlessonhomework.ui.LaunchView
import java.text.DecimalFormat

class LaunchesAdapter: ListAdapter<LaunchItem, LaunchesAdapter.LaunchViewHolder>(DiffCallBack) {

    class LaunchViewHolder(val binding: LaunchViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LaunchViewBinding.inflate(inflater, parent, false)
        return LaunchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.launchViewTitleTv.text = item.title
        holder.binding.launchViewDescriptionTv.text = item.description
        holder.binding.launchViewDateTv.text = item.date
        holder.binding.upcomingIv.setImageResource(item.imageRes)
    }

    companion object {
        val DiffCallBack = object : DiffUtil.ItemCallback<LaunchItem>() {

            override fun areItemsTheSame(oldItem: LaunchItem, newItem: LaunchItem): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: LaunchItem, newItem: LaunchItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}