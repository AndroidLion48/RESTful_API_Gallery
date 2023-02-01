package com.eaglewarrior.retrofitcrashapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.eaglewarrior.retrofitcrashapp.databinding.ActivityMainBinding
import retrofit2.HttpException
import java.io.IOException

const val TAG = "Tag"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            val response = try {
                RetrofitInstance.api.getTodos()
            } catch (e: IOException) {
                Log.e(TAG, e.message.toString())
                binding.progressBar.isVisible = false

                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG,  e.message.toString())
                binding.progressBar.isVisible = false

                return@launchWhenCreated
            }
            Log.wtf("Response", response.toString())
            if(response.isSuccessful && response.body() != null) {

                todoAdapter.listOfTodos = response.body()!!

            } else {
                Log.e(TAG , "Response not successful")
            }
            binding.progressBar.isVisible = false
        }
    }

    private fun setupRecyclerView() = binding.rvTodos.apply {
        todoAdapter = TodoAdapter()
        adapter = todoAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }
}
