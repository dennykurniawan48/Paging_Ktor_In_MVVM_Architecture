package com.signaltekno.paging3androidcompose.dataremote

import com.signaltekno.paging3androidcompose.NetworkResult
import com.signaltekno.paging3androidcompose.model.Characters

interface ApiService {
    suspend fun retriveCharacter(page: Int): NetworkResult<Characters>?
}