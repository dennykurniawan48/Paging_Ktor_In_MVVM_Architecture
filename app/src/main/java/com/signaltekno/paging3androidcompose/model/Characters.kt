package com.signaltekno.paging3androidcompose.model

import kotlinx.serialization.Serializable

@Serializable
data class Characters(
    val info: Info,
    val results: List<Result>
)