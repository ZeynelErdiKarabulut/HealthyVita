package com.zerdi.schoolchattingapp.presentation.login

import com.zerdi.schoolchattingapp.data.firebase.auth.model.LoginModel

sealed class LoginEvent {
    data class Login(val loginInfo: LoginModel?) : LoginEvent()
}
