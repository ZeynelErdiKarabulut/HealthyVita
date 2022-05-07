package com.zerdi.schoolchattingapp.presentation.login

data class LoginState(
    val error: String? = null,
    val isLoading: Boolean? = false,
    val loggedIn: Boolean? = null
)
