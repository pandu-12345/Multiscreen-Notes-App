package com.example.frag3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.frag3.databinding.ViewsBinding
import com.example.fragment_app.Data.Entity.Notes


class NotesAdapter(private var notes:List<Notes>, val Listner:OnClick): Adapter<NotesAdapter.MyViewHolder>() {
    inner class MyViewHolder(private val binding: ViewsBinding): ViewHolder(binding.root) {
        fun bind(notes: Notes){
            binding.apply {
                Title.text=notes.title
                Dic.text=notes.des
                root.setOnClickListener{
                    Listner.onClickListner(notes)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=ViewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val notes=notes[position]
        holder.bind(notes)
    }
    interface OnClick{
         fun onClickListner(notes: Notes)
    }
}