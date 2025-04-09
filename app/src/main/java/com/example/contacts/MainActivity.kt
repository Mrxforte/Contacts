package com.example.contacts

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts.adapters.LastSeenUserAdapter
import com.example.contacts.adapters.UserListItemAdapter
import com.example.contacts.databinding.ActivityMainBinding
import com.example.contacts.models.UserModel
import com.example.contacts.screens.UserProfile
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list = arrayListOf<UserModel>()
    private var listOfImages = arrayListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadData()
        loadUI()
        loadLastSeenUsers()
    }

    private fun loadLastSeenUsers() {
        var adapter1 = LastSeenUserAdapter(list)
        var myLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        binding.lastSeenUsersList.apply {
            adapter = adapter1
            layoutManager = myLayoutManager
        }
//    letters list
        val uppercaseLetters = listOf<String>(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"
        )
//        letter scroll
        binding.lettersScroll.adapter =
            ArrayAdapter<String>(this, R.layout.letter_item, uppercaseLetters)
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


        var adapter = UserListItemAdapter(this@MainActivity, list)
        binding.usersList.adapter = adapter
        binding.usersList.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "${list[i].name} is pressed", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, UserProfile::class.java)
            startActivity(intent)
        }
    }
}