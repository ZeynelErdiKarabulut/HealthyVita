package com.zerdi.schoolchattingapp.data.firebase.storage.source

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import java.util.*
import javax.inject.Inject

class FirebaseStorageSourceProvider @Inject constructor(private val firebaseStorage: FirebaseStorage) :
    FirebaseStorageSource {
    override suspend fun addImageToStorageForDoctors(
        profileImage: Uri,
        currentUserId: String
    ): String {
        try {
            val reference = firebaseStorage.reference.child("doctorsImages/${currentUserId}.jpg")
            reference.putFile(profileImage).await()
            return reference.downloadUrl.await().toString()
        } catch (e: Exception) {
            throw Exception(e.localizedMessage)
        }
    }

    override suspend fun addImageToStorageForPatients(
        profileImage: Uri,
        currentUserId: String
    ): String {
        try {
            val reference = firebaseStorage.reference.child("patientsImages/${currentUserId}.jpg")
            reference.putFile(profileImage).await()
            return reference.downloadUrl.await().toString()
        } catch (e: Exception) {
            throw Exception(e.localizedMessage)
        }
    }

    override suspend fun addMessageImageToStorage(
        profileImage: Uri,
        currentUserId: String
    ): String {
        try {
            val reference =
                firebaseStorage.reference.child("attachedImages/${UUID.randomUUID()}.jpg")
            reference.putFile(profileImage).await()
            return reference.downloadUrl.await().toString()
        } catch (e: Exception) {
            throw Exception(e.localizedMessage)
        }
    }
}