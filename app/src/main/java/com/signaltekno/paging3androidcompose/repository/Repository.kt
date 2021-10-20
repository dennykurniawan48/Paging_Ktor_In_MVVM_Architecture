package com.signaltekno.paging3androidcompose.repository

import android.util.Log
import com.signaltekno.paging3androidcompose.NetworkResult
import com.signaltekno.paging3androidcompose.dataremote.ApiServiceImpl
import com.signaltekno.paging3androidcompose.model.Characters
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ViewModelScoped
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor() {
    val client = HttpClient(Android){
        install(JsonFeature)
    }
    suspend fun getCharacter(): NetworkResult<Characters>?{
        val data = ApiServiceImpl(client = client).retriveCharacter("")
        Log.d("response d", data.toString())
        return data
    }
}