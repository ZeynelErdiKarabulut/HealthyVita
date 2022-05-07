package com.zerdi.schoolchattingapp.presentation.register.doctor


import com.zerdi.schoolchattingapp.data.firebase.auth.model.RegisterModel

sealed class DoctorsRegisterEvent {
    data class CreateUser(val registerModel: RegisterModel) : DoctorsRegisterEvent()
}
