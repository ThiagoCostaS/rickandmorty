package com.example.rickandmortyapi.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.rickandmortyapi.data.useCases.GetAllCharactersUseCase
import com.example.rickandmortyapi.factory.CharactersFactory.characterMock
import com.example.rickandmortyapi.ui.listcharacters.viewmodel.CharacterViewAction
import com.example.rickandmortyapi.ui.listcharacters.viewmodel.CharacterViewModel
import com.example.rickandmortyapi.ui.listcharacters.viewmodel.CharacterViewState
import com.example.rickandmortyapi.viewmodel.livedatautils.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals

@RunWith(MockitoJUnitRunner::class)
class CharacterViewModelTest {

    @Mock
    private lateinit var getAllCharactersUseCase: GetAllCharactersUseCase


    private lateinit var viewModel: CharacterViewModel

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)

        viewModel = CharacterViewModel(
            getAllCharactersUseCase,
            UnconfinedTestDispatcher()
        )
    }

    @Test
    fun `dispatchAction should get users remote and update view state to ShowCharacters`() =
        runBlocking {
            val expectedViewState = CharacterViewState.ShowCharacters(characterMock())

            `when`(getAllCharactersUseCase.invoke(1)).thenReturn(expectedViewState.character)

            viewModel.dispatchAction(CharacterViewAction.GetCharacters)

            val actualViewState = viewModel.viewState.getOrAwaitValue()

            assertEquals(expectedViewState, actualViewState)
        }


    @Test
    fun `dispatchAction should update view state to Error if an exception is thrown`() =
        runBlocking {
            val expectedErrorMessage = "Unknown error"
            `when`(getAllCharactersUseCase.invoke(1)).thenThrow(RuntimeException(expectedErrorMessage))


            viewModel.dispatchAction(CharacterViewAction.GetCharacters)

            val actualViewState = viewModel.viewState.getOrAwaitValue()
            assertEquals(CharacterViewState.Error(expectedErrorMessage), actualViewState)
        }
}