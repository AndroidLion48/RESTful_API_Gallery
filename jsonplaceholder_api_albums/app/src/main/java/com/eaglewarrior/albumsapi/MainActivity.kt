package com.eaglewarrior.albumsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import com.eaglewarrior.albumsapi.databinding.ActivityMainBinding
import com.eaglewarrior.albumsapi.models.AlbumsResponse
import com.eaglewarrior.albumsapi.repositories.PhRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var phRepository = PhRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var albumsResponse: AlbumsResponse?
        lifecycleScope.launch(Dispatchers.IO){
            albumsResponse = phRepository.getAlbumsById(65).body()

            withContext(Dispatchers.Main){
                binding.titleTv.text = albumsResponse?.get(0)?.title
                binding.idTv.text = albumsResponse?.get(0)?.id.toString()
                binding.userIdTv.text = albumsResponse?.get(0)?.userId.toString()
            }
        }
    }
}
