package com.zerdi.schoolchattingapp.presentation.forum.forumfeed

import com.zerdi.schoolchattingapp.data.firebase.firestore.model.ForumModel
import com.zerdi.schoolchattingapp.presentation.forum.UserModel

data class ForumState(
    val doctorInfo: UserModel? = null,
    val patientInfo: UserModel? = null,
    val forumInfo: List<ForumModel>? = null,
    val isLoading: Boolean? = false,
    val error: String? = null
)
