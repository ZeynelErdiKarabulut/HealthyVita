package com.zerdi.schoolchattingapp.presentation.profile

sealed class ProfileEvent {
    data class FetchDoctorData(val currentUserId: String?) : ProfileEvent()
    data class FetchPatientData(val currentUserId: String?) : ProfileEvent()
}
