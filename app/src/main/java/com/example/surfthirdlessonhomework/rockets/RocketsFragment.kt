package com.example.surfthirdlessonhomework.rockets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.surfthirdlessonhomework.ItemDecoration
import com.example.surfthirdlessonhomework.R
import com.example.surfthirdlessonhomework.databinding.FragmentLaunchesBinding
import com.example.surfthirdlessonhomework.databinding.FragmentRocketsBinding
import com.example.surfthirdlessonhomework.launches.LaunchItem
import com.example.surfthirdlessonhomework.launches.LaunchesAdapter

class RocketsFragment : Fragment() {

    companion object {
        fun newInstance() = RocketsFragment()
    }

    private lateinit var rocketsAdapter: RocketsAdapter
    private var _binding: FragmentRocketsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRocketsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        val list = listOf<RocketItem>(
            RocketItem(
                "Falcon 1",
                false,
                R.drawable.falcon_first_flight
            ),
            RocketItem(
                "Falcon 9",
                true,
                R.drawable.f9rocket
            ),
            RocketItem(
                "Big Falcon Rocket",
                false,
                R.drawable.falcon_9
            )
        )
        rocketsAdapter.submitList(list)
    }

    private fun setupRecyclerView() = binding.recycler.apply {
        rocketsAdapter = RocketsAdapter(requireContext())
        adapter = rocketsAdapter
        layoutManager = LinearLayoutManager(requireContext())
        val resources = requireContext().resources
        val space = resources?.getDimensionPixelSize(R.dimen.rockets_space)
        val left = resources?.getDimensionPixelSize(R.dimen.item_space_left)
        val right = resources?.getDimensionPixelSize(R.dimen.item_space_right)
        addItemDecoration(ItemDecoration(space, left, right))

    }

}