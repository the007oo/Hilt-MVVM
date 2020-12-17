package com.phattarapong.hilt.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import com.phattarapong.hilt.database.CharacterDao
import com.phattarapong.hilt.database.CharacterLocal
import com.phattarapong.hilt.model.asLocalList
import com.phattarapong.hilt.network.ApiService
import com.phattarapong.hilt.network.Result
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

interface MainRepository {
    suspend fun refreshCharacterList()
}

@ActivityRetainedScoped
class MainRepositoryImpl @Inject constructor(val dao: CharacterDao, val apiService: ApiService) :
    MainRepository {

    private val _characterList = MutableLiveData<Result<List<CharacterLocal>>>()
    val characterList = _characterList

    override suspend fun refreshCharacterList() {
        _characterList.value = Result.Loading

        try {
            dao.insertAll(apiService.getCharacters().results!!.asLocalList())
        } catch (e: Exception) {
            _characterList.value = Result.Error(e.message!!)
        }

        try {
            dao.getAll().asFlow().collect {
                _characterList.value = Result.Success(it)
            }
        } catch (e: Exception) {
            _characterList.value = Result.Error(e.message!!)
        }
    }

}