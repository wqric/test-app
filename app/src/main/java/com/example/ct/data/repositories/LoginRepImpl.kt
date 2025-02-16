package com.example.ct.data.repositories

import com.example.ct.domain.interfaces.LoginRep
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

class LoginRepImpl(private val supabaseClient: SupabaseClient): LoginRep  {
    override suspend fun signIn(_email: String, _password: String) {
        supabaseClient.auth.signInWith(Email) {
            email = _email
            password = _password
        }
    // rtgtr
    }
}