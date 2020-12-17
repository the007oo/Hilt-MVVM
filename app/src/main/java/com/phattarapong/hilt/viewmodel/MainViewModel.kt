package com.phattarapong.hilt.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phattarapong.hilt.repository.MainRepositoryImpl
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.launch

@ActivityRetainedScoped
class MainViewModel @ViewModelInject constructor(val mainRepositoryImpl: MainRepositoryImpl) : ViewModel() {

    var characterList = mainRepositoryImpl.characterList

    init {
        viewModelScope.launch {
            mainRepositoryImpl.refreshCharacterList()
        }
    }
}