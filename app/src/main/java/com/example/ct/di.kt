package com.example.ct

import com.example.ct.data.repositories.LoginRepImpl
import com.example.ct.data.sharedPrefs.SharedPrefs
import com.example.ct.domain.interfaces.LoginRep
import com.example.ct.domain.usecases.LoginUseCase
import com.example.ct.presentation.viewmodels.MainViewModel
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel {
        MainViewModel(get())
    }

    single<LoginUseCase> {
        LoginUseCase(get())
    }

    single<LoginRep> {
        LoginRepImpl(get())
    }

    single<SharedPrefs> {
        SharedPrefs(context = get())
    }

    single<SupabaseClient> {
        createSupabaseClient(
            supabaseUrl = "https://uymyhcnmwpznvmkqunbd.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InV5bXloY25td3B6bnZta3F1bmJkIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzcxMzY4NzAsImV4cCI6MjA1MjcxMjg3MH0.1IT5n_WlbxOE0j81seWLauDLWyOsJK-wXRnUJnVKnuo"
        ) {
            install(Auth)
            install(Postgrest)
            //install other modules
        }
    }
}