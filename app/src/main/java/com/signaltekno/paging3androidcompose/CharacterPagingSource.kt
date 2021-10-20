package com.signaltekno.paging3androidcompose

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.signaltekno.paging3androidcompose.model.Characters
import com.signaltekno.paging3androidcompose.model.Result
import com.signaltekno.paging3androidcompose.repository.Repository
import java.io.IOException
import javax.inject.Inject

class CharacterPagingSource @Inject constructor(private val repository: Repository): PagingSource<Int, Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val page = params.key ?: 1

            val response = repository.getCharacter(page)
            val characters: List<Result> = response!!.data!!.results

            val prevKey = if (page > 0) page - 1 else null
            val nextKey = if (response.data!!.info.next != null) page + 1 else null

            LoadResult.Page(data = characters, prevKey = prevKey, nextKey = nextKey)
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }
}