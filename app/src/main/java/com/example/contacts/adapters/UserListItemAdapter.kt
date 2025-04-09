package com.example.contacts.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.contacts.R
import com.example.contacts.databinding.UserListItemLayoutBinding
import com.example.contacts.models.UserModel

class UserListItemAdapter(context: Context, val list: List<UserModel>) :
    ArrayAdapter<UserModel>(context, R.layout.user_list_item_layout, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding: UserListItemLayoutBinding = if (convertView == null) {
            UserListItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            UserListItemLayoutBinding.bind(convertView)
        }
        binding.userImg.setImageResource(list[position].userImg)
        binding.userName.text = list[position].name
        binding.userPhone.text = list[position].mobilePhoneNumber
        return binding.root
    }
}