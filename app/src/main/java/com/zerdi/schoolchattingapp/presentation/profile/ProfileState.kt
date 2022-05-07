package com.zerdi.schoolchattingapp.presentation.profile

import com.zerdi.schoolchattingapp.presentation.forum.UserModel

data class ProfileState(
    val doctorInfo: UserModel? = null,
    val patientInfo: UserModel? = null
)