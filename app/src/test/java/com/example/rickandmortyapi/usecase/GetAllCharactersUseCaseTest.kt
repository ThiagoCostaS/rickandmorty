package com.example.rickandmortyapi.usecase

import com.example.rickandmortyapi.data.CharacterRepository
import com.example.rickandmortyapi.data.useCases.GetAllCharactersUseCase
import com.example.rickandmortyapi.factory.CharactersFactory.characterMock

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class GetAllCharactersUseCaseTest {
    private lateinit var repository : CharacterRepository
    private lateinit var useCase: GetAllCharactersUseCase

    @Before
    fun setup(){
        repository = mock(CharacterRepository::class.java)
        useCase = GetAllCharactersUseCase(repository)
    }
    @Test
    fun `invoke should call getAllCharacters from repository and return result`(): Unit = runBlocking {
        `when`(repository.getAllCharacters(1)).thenReturn(characterMock())

        val result = useCase(1)

        assertEquals(characterMock(), result)
    }

    @Test(expected = Exception::class)
    fun `invoke should throw exception when repository getAllCharacters throws Exception`(): Unit = runBlocking {
        `when`(repository.getAllCharacters(1)).thenThrow(Exception("Error fetching characters"))

        useCase(1)
    }
}
