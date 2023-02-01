package com.eaglewarrior.wallpapersktx.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.eaglewarrior.wallpapersktx.paging.HomePagingSource
import com.eaglewarrior.wallpapersktx.repository.MainRepository

/**
 * Created by Clarence E Moore on 2023-01-27.
 *
 * Description:
 *
 *
 */
class HomeViewModel() : ViewModel() {
    private val repository = MainRepository()

    val homePage = Pager(config =  PagingConfig(pageSize =  30),
    pagingSourceFactory =  {
        HomePagingSource(repository.apiService())
    }).flow.cachedIn(viewModelScope)
}
