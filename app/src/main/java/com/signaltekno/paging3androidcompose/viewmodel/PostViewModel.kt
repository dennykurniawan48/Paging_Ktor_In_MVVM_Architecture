package com.signaltekno.paging3androidcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.signaltekno.paging3androidcompose.NetworkResult
import com.signaltekno.paging3androidcompose.model.Characters
import com.signaltekno.paging3androidcompose.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class PostViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {
    var datax: MutableLiveData<NetworkResult<Characters>> = MutableLiveData(NetworkResult.Loading())

    fun getDatax(){
        viewModelScope.launch {
            datax.value = repository.getCharacter()
        }
    }
}