package com.zerdi.schoolchattingapp.presentation.chat

import com.zerdi.schoolchattingapp.data.firebase.firestore.model.MessageModel

sealed class ChatEvent {
    data class AddMessageToFirebase(val messageModel: MessageModel) : ChatEvent()
    data class FetchMessage(val currentUserId: String, val receiverId: String) : ChatEvent()
}
