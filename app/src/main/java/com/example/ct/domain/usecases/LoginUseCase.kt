package com.example.ct.domain.usecases

import com.example.ct.domain.interfaces.LoginRep

class LoginUseCase(private val loginRep: LoginRep) {
    suspend fun signIn(email: String, password: String): Boolean {
        try {
            loginRep.signIn(_email = email, _password = password)
            return true
        } catch (e:Exception) {
            e.printStackTrace()
            return false
        }
    }
}