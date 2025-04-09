package com.example.contacts.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.contacts.R
import com.example.contacts.databinding.LastSeenUserItemLayoutBinding
import com.example.contacts.models.UserModel

class LastSeenUserAdapter(context: Context, val list: List<UserModel>) :
    ArrayAdapter<UserModel>(context, R.layout.last_seen_user_item_layout, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding: LastSeenUserItemLayoutBinding = if (convertView == null) {
            LastSeenUserItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            LastSeenUserItemLayoutBinding.bind(convertView)
        }
        return binding.root
    }
}