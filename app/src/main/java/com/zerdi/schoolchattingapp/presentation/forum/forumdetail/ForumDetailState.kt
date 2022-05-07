package com.zerdi.schoolchattingapp.presentation.forum.forumdetail

import com.zerdi.schoolchattingapp.data.firebase.firestore.model.ForumDetailModel

data class ForumDetailState(
    val answerList : List<ForumDetailModel>? = null
)
