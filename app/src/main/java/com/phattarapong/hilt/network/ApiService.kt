package com.phattarapong.hilt.network

import com.phattarapong.hilt.model.CharacterRemote
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): CharacterRemote
}