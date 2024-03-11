package com.example.rickandmortyapi.factory

import com.example.rickandmortyapi.domain.model.CharacterDomain
import com.example.rickandmortyapi.domain.model.InfoDomain
import com.example.rickandmortyapi.domain.model.LocationDomain
import com.example.rickandmortyapi.domain.model.OriginDomain
import com.example.rickandmortyapi.domain.model.ResultDomain

object CharactersFactory {

    fun characterMock(): CharacterDomain {

        val info = InfoDomain(
            count = 1,
            next = null,
            pages = 1,
            prev = null
        )

        val charactersList = listOf(
            ResultDomain(
                created = "10-10-1998",
                episode = listOf("S01E01", "S01E02"),
                gender = "Male",
                id = 1,
                image = "https://example.com/image.png",
                location = LocationDomain("Earth", "Planet Earth"),
                name = "Rick Sanchez",
                origin = OriginDomain("Earth", "Dimension C-137"),
                species = "Human",
                status = "Alive",
                type = "Humanoid",
                url = "https://example.com/rick"
            )
        )

        return CharacterDomain(info, charactersList)
    }





}