package com.eaglewarrior.wallpapersktx.viewModels

import androidx.lifecycle.ViewModel
import com.eaglewarrior.wallpapersktx.repository.MainRepository

/**
 * Created by Clarence E Moore on 2023-01-27.
 *
 * Description:
 *
 *
 */
class PopularViewModel() : ViewModel(){
    val repository = MainRepository()
}
