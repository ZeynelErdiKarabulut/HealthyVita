package com.zerdi.schoolchattingapp.domain

import com.zerdi.schoolchattingapp.common.Resource
import com.zerdi.schoolchattingapp.data.repository.Repository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchCurrentUserIdUseCase @Inject constructor(val repository: Repository) {

    suspend fun invoke(currentUserId: String) = flow {
        emit(Resource.Loading)
        try {
            val currentUserInfo = repository.fetchCurrentPatientInfo(currentUserId)
            emit(Resource.Success(currentUserInfo))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage))
        }
    }
}