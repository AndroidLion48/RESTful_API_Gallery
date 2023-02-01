package com.eaglewarrior.mockapi.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import com.eaglewarrior.mockapi.R
import com.eaglewarrior.mockapi.databinding.ActivityMainBinding
import com.eaglewarrior.mockapi.models.Comment
import com.eaglewarrior.mockapi.models.CommentResponse
import com.eaglewarrior.mockapi.repositories.PhRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class MainActivity : AppCompatActivity() {
    val phRepository: PhRepository = PhRepository()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var commentsList: CommentResponse?
        lifecycleScope.launch(Dispatchers.IO){
            commentsList = phRepository.getCommentsByPostId(1).body()

            withContext(Dispatchers.Main){
                val arrayAdapter = commentsList?.let { ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, it.toArray()) }
                binding.listView.adapter = arrayAdapter
            }

        }
    }
}
