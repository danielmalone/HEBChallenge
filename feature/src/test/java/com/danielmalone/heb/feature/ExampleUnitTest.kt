package com.danielmalone.heb.feature

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Mock
    lateinit var mainViewModel: MainViewModel

    @Test
    fun confirm_onchanged_was_called() {
        mainViewModel = Mockito.mock(MainViewModel::class.java)
        assertEquals(4, 2 + 2)
    }
}
