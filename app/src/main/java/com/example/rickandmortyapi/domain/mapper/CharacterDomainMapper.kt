package com.example.rickandmortyapi.domain.mapper

import com.example.rickandmortyapi.domain.model.CharacterDomain
import com.example.rickandmortyapi.domain.model.InfoDomain
import com.example.rickandmortyapi.domain.model.LocationDomain
import com.example.rickandmortyapi.domain.model.OriginDomain
import com.example.rickandmortyapi.domain.model.ResultDomain
import com.example.rickandmortyapi.remote.model.Character
import com.example.rickandmortyapi.remote.model.Info
import com.example.rickandmortyapi.remote.model.Location
import com.example.rickandmortyapi.remote.model.Origin
import com.example.rickandmortyapi.remote.model.Result


fun Character.toDomain() = CharacterDomain(
    info = info.toDomain(),
    results = results.map { it.toDomain() }
)

fun Info.toDomain() = InfoDomain(
    count = count,
    next = next,
    pages = pages,
    prev = prev
)

fun Result.toDomain() = ResultDomain(
    created = created,
    episode = episode,
    gender = gender,
    id = id,
    image = image,
    location = location.toDomain(),
    name = name,
    origin = origin.toDomain(),
    species = species,
    status = status,
    type = type,
    url = url
)

fun Location.toDomain() = LocationDomain(
    name,
    url
)

fun Origin.toDomain() = OriginDomain(
    name = name,
    url = url
)