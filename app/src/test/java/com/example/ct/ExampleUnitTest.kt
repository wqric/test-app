package com.example.ct

import com.example.ct.presentation.checkEmail
import com.example.ct.presentation.checkPass
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun emailValidation()  {
        assertEquals(true, checkEmail("wefrerfre"))
    }

    @Test
    fun passValidation() {
        assertEquals(true, checkPass("frefrrefrefg"))
        assertEquals(false, checkPass("fref"))
    }
}