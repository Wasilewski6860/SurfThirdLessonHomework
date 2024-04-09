package com.example.surfthirdlessonhomework.launches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.surfthirdlessonhomework.ItemDecoration
import com.example.surfthirdlessonhomework.R
import com.example.surfthirdlessonhomework.databinding.FragmentLaunchesBinding

class LaunchesFragment : Fragment() {

    companion object {
        fun newInstance() = LaunchesFragment()
    }

    private lateinit var launchesAdapter: LaunchesAdapter
    private var _binding: FragmentLaunchesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLaunchesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        val list = listOf<LaunchItem>(
            LaunchItem(
                "Starlink 2",
                "CCAES SLC 40",
                "16-12-2014",
                R.drawable.falcon_first_flight
            ),
            LaunchItem(
                "DemoSat",
                "AAAES SLC 40",
                "06-07-2018",
                R.drawable.f9
            ),
            LaunchItem(
                "Falcon 9 Test",
                "CCAES SEC 40",
                "18-03-2019",
                R.drawable.falcon_9
            ),
            LaunchItem(
                "CRS - 2",
                "CAAES SLC 40",
                "18-12-2019",
                R.drawable.crs_2
            )
        )
        launchesAdapter.submitList(list)
    }

    private fun setupRecyclerView() = binding.recycler.apply {
        launchesAdapter = LaunchesAdapter()
        adapter = launchesAdapter
        layoutManager = LinearLayoutManager(requireContext())
        val resources = requireContext().resources
        val space = resources?.getDimensionPixelSize(R.dimen.launches_space)
        val left = resources?.getDimensionPixelSize(R.dimen.item_space_left)
        val right = resources?.getDimensionPixelSize(R.dimen.item_space_right)
        addItemDecoration(ItemDecoration(space, left, right))

    }

}