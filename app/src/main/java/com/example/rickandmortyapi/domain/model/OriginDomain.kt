package com.example.rickandmortyapi.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OriginDomain(
    val name: String,
    val url: String
):Parcelable
