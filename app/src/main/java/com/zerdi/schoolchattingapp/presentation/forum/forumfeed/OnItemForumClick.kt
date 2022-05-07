package com.zerdi.schoolchattingapp.presentation.forum.forumfeed

import com.zerdi.schoolchattingapp.data.firebase.firestore.model.ForumModel

interface OnItemForumClick {
    fun onItemForumClick(forumModel: ForumModel)
}