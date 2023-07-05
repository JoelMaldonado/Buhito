package com.jjmf.elementaryschool.data.repository

import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

interface ImagenesRepository {
    suspend fun getListImagen(path:String) : List<String>
}

class ImagenesRepositoryImpl @Inject constructor(
    private val storage: StorageReference
) : ImagenesRepository{
    override suspend fun getListImagen(path:String): List<String> {
        val list = storage.child(path).listAll().await()
        return list.items.map { it.downloadUrl.await().toString() }
    }
}