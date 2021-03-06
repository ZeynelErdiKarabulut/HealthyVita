package com.zerdi.schoolchattingapp.data.repository

import android.net.Uri
import com.zerdi.schoolchattingapp.data.firebase.auth.model.LoginModel
import com.zerdi.schoolchattingapp.data.firebase.auth.model.RegisterModel
import com.zerdi.schoolchattingapp.data.firebase.auth.source.FirebaseAuthSourceProvider
import com.zerdi.schoolchattingapp.data.firebase.firestore.model.ForumDetailModel
import com.zerdi.schoolchattingapp.data.firebase.firestore.model.ForumModel
import com.zerdi.schoolchattingapp.data.firebase.firestore.model.MessageModel
import com.zerdi.schoolchattingapp.data.firebase.firestore.source.FirebaseFirestoreSourceProvider
import com.zerdi.schoolchattingapp.data.firebase.storage.source.FirebaseStorageSourceProvider
import javax.inject.Inject

class Repository @Inject constructor(
    private val firebaseAuthSourceProvider: FirebaseAuthSourceProvider,
    private val firebaseFirestoreSourceProvider: FirebaseFirestoreSourceProvider,
    private val firebaseStorageProvider: FirebaseStorageSourceProvider
) {
    suspend fun signUp(registerModel: RegisterModel) =
        firebaseAuthSourceProvider.signUpWithEmail(registerModel)

    suspend fun getCurrentUserId() = firebaseAuthSourceProvider.getCurrentUserId()

    suspend fun saveMediaToStorageForDoctors(profileImage: Uri, currentUserId: String) =
        firebaseStorageProvider.addImageToStorageForDoctors(profileImage, currentUserId)

    suspend fun saveMediaToStorageForPatients(profileImage: Uri, currentUserId: String) =
        firebaseStorageProvider.addImageToStorageForPatients(profileImage, currentUserId)

    suspend fun saveMediaToStorageForMessages(profileImage: Uri, currentUserId: String) =
        firebaseStorageProvider.addMessageImageToStorage(profileImage, currentUserId)

    suspend fun saveInfoToFirestoreForTeachers(
        userName: String, currentUserId: String, imageUrl: String, userMail: String, field: String
    ) =
        firebaseFirestoreSourceProvider.addDoctorInfoToFirebase(
            userName,
            currentUserId, imageUrl, userMail, field
        )

    suspend fun saveInfoToFirestoreForPatients(
        currentUserId: String,
        imageUrl: String,
        userName: String,
        userMail: String,
        userPassword: String
    ) =
        firebaseFirestoreSourceProvider.addPatientInfoToFirebase(
            currentUserId, imageUrl, userName, userMail, userPassword
        )

    suspend fun signIn(signingInfo: LoginModel) = firebaseAuthSourceProvider.signIn(signingInfo)

    suspend fun fetchDoctorData() =
        firebaseFirestoreSourceProvider.fetchDoctorInfo()

    suspend fun fetchMessages(currentUserId: String, receiverId: String) =
        firebaseFirestoreSourceProvider.fetchMessagesFromFirebase(currentUserId, receiverId)

    suspend fun saveMessageToFirestore(messageModel: MessageModel, image: String) =
        firebaseFirestoreSourceProvider.addMessagesToFirebase(messageModel, image)

    suspend fun saveForumMessagesToFirebase(forumModel: ForumModel) {
        firebaseFirestoreSourceProvider.addForumToFirebase(forumModel)
    }

    suspend fun fetchForumMessagesFromFirebase() =
        firebaseFirestoreSourceProvider.fetchForumMessages()

    suspend fun fetchCurrentPatientInfo(currentUserId: String) =
        firebaseFirestoreSourceProvider.fetchCurrentPatientInfo(currentUserId)

    suspend fun fetchCurrentDoctorInfo(currentUserId: String) =
        firebaseFirestoreSourceProvider.fetchCurrentDoctorInfo(currentUserId)

    suspend fun addForumAnswersToFirebase(forumAnswersModel: ForumDetailModel) =
        firebaseFirestoreSourceProvider.addForumAnswers(forumAnswersModel)

    suspend fun fetchForumAnswersModel(messageId: String) =
        firebaseFirestoreSourceProvider.fetchForumAnswers(messageId)

    suspend fun fetchPatientMessage(currentUserId: String) =
        firebaseFirestoreSourceProvider.fetchPatientMessageFromFirebase(currentUserId)
}
