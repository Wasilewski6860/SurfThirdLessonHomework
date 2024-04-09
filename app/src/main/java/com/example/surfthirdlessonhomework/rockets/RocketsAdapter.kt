package com.example.surfthirdlessonhomework.rockets

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.surfthirdlessonhomework.R
import com.example.surfthirdlessonhomework.databinding.LaunchViewBinding
import com.example.surfthirdlessonhomework.databinding.RocketViewBinding
import com.example.surfthirdlessonhomework.ui.LaunchView
import java.text.DecimalFormat

class RocketsAdapter(val context: Context): ListAdapter<RocketItem, RocketsAdapter.RocketViewHolder>(DiffCallBack) {

    class RocketViewHolder(val binding: RocketViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RocketViewBinding.inflate(inflater, parent, false)
        return RocketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.rocketViewTitleTv.text = item.title
        holder.binding.rocketViewButton.text = if (item.isActive) "active" else "inactive"
        holder.binding.rocketViewButton.setBackgroundColor(ContextCompat.getColor(context,if(item.isActive) R.color.colorActive else R.color.colorInactive))
        holder.binding.rocketIv.setImageResource(item.imageRes)
    }

    companion object {
        val DiffCallBack = object : DiffUtil.ItemCallback<RocketItem>() {

            override fun areItemsTheSame(oldItem: RocketItem, newItem: RocketItem): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: RocketItem, newItem: RocketItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}