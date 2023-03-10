package com.eaglewarrior.wallpapersktx.ui.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.eaglewarrior.wallpapersktx.recyclerVeiw.RecyclerViewAdapter

/**
 * Created by Clarence E Moore on 2023-01-26.
 *
 * Description:
 *
 *
 */
abstract class BaseFragment<VB : ViewBinding>(
    private val layoutInflater: (inflater: LayoutInflater) -> VB
) : Fragment() {

    abstract var recyclerViewAdapter: RecyclerViewAdapter

    private var _binding: VB? = null
    val binding: VB
        get() = _binding as VB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = layoutInflater.invoke(inflater)

        if (_binding == null) {
            throw IllegalArgumentException("binding cannot be null")
        }

        initViewModel()
        initRecyclerView()
        return binding.root
    }
    abstract fun initViewModel()
    abstract fun initRecyclerView()
}
