package com.signaltekno.paging3androidcompose.dataremote

import com.signaltekno.paging3androidcompose.NetworkResult
import com.signaltekno.paging3androidcompose.model.Characters

interface ApiService {
    suspend fun retriveCharacter(name: String): NetworkResult<Characters>?
}