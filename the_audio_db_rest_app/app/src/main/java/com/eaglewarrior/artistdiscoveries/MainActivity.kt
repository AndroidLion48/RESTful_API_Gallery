package com.eaglewarrior.artistdiscoveries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.eaglewarrior.artistdiscoveries.databinding.ActivityMainBinding
import com.eaglewarrior.artistdiscoveries.models.ArtistAlbumsResponse
import com.eaglewarrior.artistdiscoveries.repositories.AudioDBRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var audioDBRepository = AudioDBRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var artistAlbumsResponse: ArtistAlbumsResponse?
        lifecycleScope.launch(Dispatchers.IO){
            artistAlbumsResponse = audioDBRepository.getAlbumByArtist("nas").body()

            withContext(Dispatchers.Main){
                binding.albumsTv.text = artistAlbumsResponse?.album.toString()
            }
        }
    }
}
