package com.signaltekno.paging3androidcompose.dataremote

import android.util.Log
import com.signaltekno.paging3androidcompose.NetworkResult
import com.signaltekno.paging3androidcompose.model.Characters
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.lang.Exception

class ApiServiceImpl(
    private val client: HttpClient
): ApiService {
    override suspend fun retriveCharacter(page: Int): NetworkResult<Characters>? {

        return try{
            val response: Characters = client.get{
                url("https://rickandmortyapi.com/api/character?page=${page}")
            }
            NetworkResult.Success(response)
        }catch (e: RedirectResponseException){
            NetworkResult.Error(e.response.status.description)
        }catch (e: ClientRequestException){
            NetworkResult.Error(e.response.status.description)
        }catch (e: ServerResponseException){
            NetworkResult.Error(e.response.status.description)
        }catch (e: Exception){
            Log.d("response -e", e.message.toString())
            NetworkResult.Error(e.message)
        }
    }
}