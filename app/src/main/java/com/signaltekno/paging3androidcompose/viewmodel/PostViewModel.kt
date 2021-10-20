package com.signaltekno.paging3androidcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.signaltekno.paging3androidcompose.CharacterPagingSource
import com.signaltekno.paging3androidcompose.NetworkResult
import com.signaltekno.paging3androidcompose.model.Characters
import com.signaltekno.paging3androidcompose.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class PostViewModel @Inject constructor(
    val repository: Repository,
    private val charactersPagingSource: CharacterPagingSource,
): ViewModel() {
        val characters = Pager(PagingConfig(pageSize = 20)) {
            charactersPagingSource
        }.flow
}