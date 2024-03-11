package com.example.rickandmortyapi.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ResultDomain(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDomain,
    val name: String,
    val origin: OriginDomain,
    val species: String,
    val status: String,
    val type: String,
    val url: String
): Parcelable
