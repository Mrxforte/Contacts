package com.example.contacts.models

data class UserModel(
    var name: String,
    var userImg : Int,
    var homePhoneNumber: String,
    var homePhoneNumberVideoCall: String,
    var mobilePhoneNumber: String,
    var lastSeen: String,
)
