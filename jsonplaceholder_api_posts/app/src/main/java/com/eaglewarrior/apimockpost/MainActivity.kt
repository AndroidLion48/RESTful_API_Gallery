package com.eaglewarrior.apimockpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.eaglewarrior.apimockpost.databinding.ActivityMainBinding
import com.eaglewarrior.apimockpost.repositories.PhRepository
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

        lifecycleScope.launch(Dispatchers.IO) {
            val postResponse = phRepository.getPostByUserId(3)

            withContext(Dispatchers.Main) {
                binding.textView.text = postResponse.body()?.get(0)?.title
            }
        }
    }
}
