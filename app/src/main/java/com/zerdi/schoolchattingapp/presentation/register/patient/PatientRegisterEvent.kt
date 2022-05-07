package com.zerdi.schoolchattingapp.presentation.register.patient

import com.zerdi.schoolchattingapp.data.firebase.auth.model.RegisterModel


sealed class PatientRegisterEvent {
    data class CreateUser(val userRegister: RegisterModel) : PatientRegisterEvent()
}
