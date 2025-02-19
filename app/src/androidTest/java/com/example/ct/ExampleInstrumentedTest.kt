package com.example.ct

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.ct.domain.interfaces.LoginRep
import com.example.ct.domain.usecases.LoginUseCase
import com.example.ct.presentation.activities_screens.LoginActivity
import com.example.ct.presentation.activities_screens.LoginScreen
import com.example.ct.presentation.checkEmail
import com.example.ct.presentation.checkPass
import com.example.ct.presentation.viewmodels.MainViewModel
import com.example.ct.ui.theme.CTTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val testRule = createComposeRule()
    @Test
    fun successAuth() {
        testRule.setContent {
            CTTheme {
                LoginScreen(MainViewModel(LoginUseCase(object: LoginRep {
                    override suspend fun signIn(_email: String, _password: String) {
                        TODO("Not yet implemented")
                    }
                })))
            }

        }
    }
}