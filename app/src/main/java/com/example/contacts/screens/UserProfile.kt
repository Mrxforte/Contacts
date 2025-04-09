package com.example.contacts.screens

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contacts.R
import com.example.contacts.adapters.LastSeenUserAdapter
import com.example.contacts.databinding.ActivityUserProfileBinding
import com.example.contacts.models.UserModel
import kotlin.random.Random

class UserProfile : AppCompatActivity() {
    private lateinit var binding: ActivityUserProfileBinding
    private var list = ArrayList<UserModel>()
    private var listOfImages = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadData()
        loadUI()
    }


    private fun loadData() {
        listOfImages.add(R.drawable.img1)
        listOfImages.add(R.drawable.img2)
        listOfImages.add(R.drawable.img3)
        listOfImages.add(R.drawable.img4)
        listOfImages.add(R.drawable.img5)
        listOfImages.add(R.drawable.img6)
        listOfImages.add(R.drawable.img7)
        listOfImages.add(R.drawable.img8)
        listOfImages.add(R.drawable.img9)
        listOfImages.add(R.drawable.img10)
        var randomPhoneNumber = Random.nextInt(1000)
        var lastSeenMinutes = Random.nextInt(59)
        for (i in 0..9) {
            list.add(
                UserModel(
                    "User$i",
                    listOfImages[i],
                    "+99893788$randomPhoneNumber",
                    "+7999355$randomPhoneNumber",
                    "+7988875$randomPhoneNumber",
                    lastSeenMinutes
                )
            )
        }
    }


    private fun loadUI() {
    }
}