package com.example.surfthirdlessonhomework

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.surfthirdlessonhomework.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : FragmentActivity(R.layout.activity_main) {

    private lateinit var fragmentAdapter: FragmentAdapter

    // reflection API is used under the hood
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentAdapter = FragmentAdapter(supportFragmentManager)
        binding.pager.adapter = fragmentAdapter
        binding.tabLayout.setupWithViewPager(binding.pager);

    }
}