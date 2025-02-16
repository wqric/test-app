package com.example.ct.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ct.domain.usecases.LoginUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val loginUseCase: LoginUseCase): ViewModel() {
    val isAuth = mutableStateOf(false)
    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            isAuth.value = loginUseCase.signIn(email = email, password = password)
        }
    }
}