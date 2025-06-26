package com.example.connecto.presentation.edit_profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.connecto.presentation.util.states.StandardTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(
    
) : ViewModel() {

    private val _usernameState = mutableStateOf(StandardTextFieldState())
    val usernameState: State<StandardTextFieldState> = _usernameState

    private val _githubTextFieldState = mutableStateOf(StandardTextFieldState())
    val githubTextFieldState: State<StandardTextFieldState> = _githubTextFieldState

    private val _linkedInTextFieldState = mutableStateOf(StandardTextFieldState())
    val linkedInTextFieldState: State<StandardTextFieldState> = _linkedInTextFieldState

    private val _instagramTextFieldState = mutableStateOf (StandardTextFieldState())
    val instagramTextFieldState: State<StandardTextFieldState> = _instagramTextFieldState

    private val _bioTextFieldState = mutableStateOf(StandardTextFieldState())
    val bioTextFieldState: State<StandardTextFieldState> = _bioTextFieldState

    fun setBioTextFieldState(state: StandardTextFieldState) {
        _bioTextFieldState.value = state
    }

    fun setInstagramTextFieldState(state: StandardTextFieldState)
    {
        _instagramTextFieldState.value = state
    }

    fun setLinkedInTextFieldState(state: StandardTextFieldState) {
        _linkedInTextFieldState.value = state
    }

    fun setGithubTextFieldState(state: StandardTextFieldState) {
        _githubTextFieldState.value = state
    }

    fun setUsernameState(state: StandardTextFieldState) {
        _usernameState.value = state
    }
}
