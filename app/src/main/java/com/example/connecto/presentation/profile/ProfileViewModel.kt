package com.example.connecto.presentation.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableFloatStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {

    private val _expendedRatio = mutableFloatStateOf(1f)
    val expendedRatio: State<Float> = _expendedRatio

    private val _toolbarOffsetY = mutableFloatStateOf(0f)
    val toolbarOffsetY: State<Float> = _toolbarOffsetY

    fun setExpandedRatio(value: Float) {
        _expendedRatio.floatValue = value
    }

    fun setToolbarOffsetY(value: Float) {
        _toolbarOffsetY.floatValue = value
    }
}