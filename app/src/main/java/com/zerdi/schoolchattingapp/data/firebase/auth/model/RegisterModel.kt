package com.zerdi.schoolchattingapp.data.firebase.auth.model

import android.net.Uri

data class RegisterModel(
    val email: String,
    val password: String,
    val userName: String,
    val userPhoto: Uri
)

