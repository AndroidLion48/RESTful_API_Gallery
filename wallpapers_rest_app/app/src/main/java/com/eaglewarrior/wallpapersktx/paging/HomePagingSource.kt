package com.eaglewarrior.wallpapersktx.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.eaglewarrior.wallpapersktx.model.Data
import com.eaglewarrior.wallpapersktx.network.ApiService

/**
 * Created by Clarence E Moore on 2023-01-27.
 *
 * Description:
 *
 *
 */
class HomePagingSource (
    private val apiService: ApiService
) : PagingSource<Int, Data>() {

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try {
            val nextPage = params.key ?: FIRST_PAGE_INDEX
            val responseHome = apiService.getHome(nextPage)
            LoadResult.Page(
                data = responseHome.data,
                prevKey = null,
                nextKey =  responseHome.paggination?.next?.page,
            )

        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }
    companion object{
        private const val FIRST_PAGE_INDEX = 1
    }

}
