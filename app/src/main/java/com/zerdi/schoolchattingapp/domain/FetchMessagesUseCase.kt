package com.zerdi.schoolchattingapp.domain


import com.zerdi.schoolchattingapp.common.Resource
import com.zerdi.schoolchattingapp.data.repository.Repository
import com.zerdi.schoolchattingapp.presentation.chat.FetchedMessageModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchMessagesUseCase @Inject constructor(val repository: Repository) {
    suspend fun invoke(currentUserId: String, receiverId: String) = flow {
        emit(Resource.Loading)
        try {
            val messageList = ArrayList<FetchedMessageModel>()
            repository.fetchMessages(currentUserId, receiverId).forEach { document ->
                val message = document.get("message") as String
                val senderId = document.get("sender") as String
                val imageUrl = document.get("imageUrl") as String
                val time = document.get("time") as Long
                val receiver = document.get("receiver") as String
                val list = FetchedMessageModel(message, senderId, imageUrl, time, receiver)
                messageList.add(list)
            }
            emit(Resource.Success(messageList))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage))
        }
    }.flowOn(Dispatchers.IO)
}