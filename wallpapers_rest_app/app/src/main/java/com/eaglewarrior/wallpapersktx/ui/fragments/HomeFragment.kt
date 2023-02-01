package com.eaglewarrior.wallpapersktx.ui.fragments

import android.view.View.inflate
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.eaglewarrior.wallpapersktx.databinding.FragmentHomeBinding
import com.eaglewarrior.wallpapersktx.recyclerVeiw.RecyclerViewAdapter
import com.eaglewarrior.wallpapersktx.ui.fragments.base.BaseFragment
import com.eaglewarrior.wallpapersktx.viewModels.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHome::inflate
) {

    private val viewModel : HomeViewModel by viewModels()

    override fun initViewModel() {
        lifecycleScope.launch {
            viewModel.homePage.collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }

    override fun initRecyclerView() {
        val layoutManager = GridLayoutManager(context, 3)
//        binding.homeRecyclerView.layoutManager = layoutManager
//        binding.homeRecyclerView.adapter = recyclerViewAdapter
    }

    override var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter()

}
