package com.zerdi.schoolchattingapp.domain


import com.zerdi.schoolchattingapp.common.Resource
import com.zerdi.schoolchattingapp.data.firebase.auth.model.LoginModel
import com.zerdi.schoolchattingapp.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoginUseCase @Inject constructor(val repository: Repository) {

    suspend fun invoke(signInInfo: LoginModel) = flow {
        emit(Resource.Loading)
        try {
            repository.signIn(signInInfo)?.let {
                emit(Resource.Success(null))
            }
        } catch (e: Exception) {
        }
    }.flowOn(Dispatchers.IO)
}