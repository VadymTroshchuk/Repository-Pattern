

package com.example.android.devbyteviewer.repository

import com.example.android.devbyteviewer.database.VideosDatabase
import com.example.android.devbyteviewer.network.DevByteNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideosRepository(private val database: VideosDatabase) {

    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val playlist = DevByteNetwork.devbytes.getPlaylist()
            database.videoDao.insertAll(playlist.asDatabaseModel())
        }
    }
}