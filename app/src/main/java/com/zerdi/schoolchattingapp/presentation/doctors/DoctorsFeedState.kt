package com.zerdi.schoolchattingapp.presentation.doctors

import com.zerdi.schoolchattingapp.presentation.forum.UserModel

data class DoctorsFeedState(
    val isLoading: Boolean = false,
    val list: List<DoctorFeedModel>? = null,
    val error: Boolean? = false,
    val doctorInfo: UserModel? = null,
    val patientInfo: UserModel? = null,
    val patientMessage: List<String>? = null
)