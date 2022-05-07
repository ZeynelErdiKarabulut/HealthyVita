package com.zerdi.schoolchattingapp.domain

import com.zerdi.schoolchattingapp.common.Resource
import com.zerdi.schoolchattingapp.data.firebase.firestore.model.ForumDetailModel
import com.zerdi.schoolchattingapp.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchForumAnswersUseCase @Inject constructor(var repository: Repository) {

    suspend fun invoke(messageId: String) = flow {
        emit(Resource.Loading)
        try {
            val answerList = ArrayList<ForumDetailModel>()
            repository.fetchForumAnswersModel(messageId).forEach { document ->
                val message = document.get("answers") as String
                val answer = ForumDetailModel("", message)
                answerList.add(answer)
            }
            emit(Resource.Success(answerList))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage))
        }
    }.flowOn(Dispatchers.IO)
}