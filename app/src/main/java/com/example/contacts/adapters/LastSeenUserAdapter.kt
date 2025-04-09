package com.example.contacts.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.databinding.LastSeenUserItemLayoutBinding
import com.example.contacts.models.UserModel

class LastSeenUserAdapter(val list: List<UserModel>) :
    RecyclerView.Adapter<LastSeenUserAdapter.MyViewHolder>() {
    inner class MyViewHolder(lastSeenUserItemLayoutBinding: LastSeenUserItemLayoutBinding) :
        RecyclerView.ViewHolder(lastSeenUserItemLayoutBinding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = LastSeenUserItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }
}