package com.eaglewarrior.wallpapersktx.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.eaglewarrior.wallpapersktx.databinding.FragmentMainBinding
import com.eaglewarrior.wallpapersktx.ui.fragments.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class MainFragment : Fragment() {

    // Declaring Tabs Title in ViewPager
    private val tabTitles= listOf("Home", "Random", "Popular", "Categories")

    // Declaring Fragments
    private val fragments =
        listOf(HomeFragment(),RandomFragment(),PopularFragment(),CategoriesFragment())

    // Declaring view binding
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        initViewPager()
        initTabLayout()
        initToolBar()
        return binding.root
    }

    private fun initTabLayout() {
        // Connects TabLayout with ViewPager
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    private fun initViewPager() {
        val pagerAdapter = ViewPagerAdapter(context as FragmentActivity, fragments)
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.isUserInputEnabled = true
    }
    private fun initToolBar() {
        binding.toolbar.title = "Wallpapers"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
    }
}
