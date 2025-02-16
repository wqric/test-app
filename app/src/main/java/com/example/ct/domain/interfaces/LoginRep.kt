package com.example.ct.domain.interfaces

interface LoginRep {
    suspend fun signIn(_email: String, _password: String)
}