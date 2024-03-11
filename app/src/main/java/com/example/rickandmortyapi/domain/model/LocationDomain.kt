package com.example.rickandmortyapi.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationDomain(
    val name: String,
    val url: String
):Parcelable
