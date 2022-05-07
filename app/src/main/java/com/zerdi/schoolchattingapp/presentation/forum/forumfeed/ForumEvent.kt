package com.zerdi.schoolchattingapp.presentation.forum.forumfeed

import com.zerdi.schoolchattingapp.data.firebase.firestore.model.ForumModel

sealed class ForumEvent {
    data class GetPatientData(val currentUserId: String?) : ForumEvent()
    data class GetDoctorData(val currentUserId: String?) : ForumEvent()
    object GetForumData : ForumEvent()
    data class AddForumDataToFirebase(val forumModel: ForumModel?) : ForumEvent()
}
