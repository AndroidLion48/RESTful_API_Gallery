package com.eaglewarrior.retrofitcrashapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.eaglewarrior.TodoResponseItem
import com.eaglewarrior.retrofitcrashapp.databinding.ItemTodoBinding

/**
 * Created by Clarence E Moore on 2023-01-15.
 *
 * Description:
 *
 *
 */
class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder( val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<TodoResponseItem>() {
        override fun areItemsTheSame(oldItem: TodoResponseItem, newItem: TodoResponseItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TodoResponseItem, newItem: TodoResponseItem): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var listOfTodos: List<TodoResponseItem>
        get() = differ.currentList
        set(value) { differ.submitList(value)}

    override fun getItemCount() = listOfTodos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            val todo = listOfTodos[position]
            tvTitle.text = todo.title
            checkboxDone.isChecked = todo.completed
        }
    }
}
