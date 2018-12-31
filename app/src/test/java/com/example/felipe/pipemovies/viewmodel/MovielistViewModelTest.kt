package com.example.felipe.pipemovies.viewmodel

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.Before

class MovielistViewModelTest {

    lateinit var SUT: MovielistViewModel

    @Before
    fun setup() {
        SUT = MovielistViewModel()
    }

    @Test
    fun foo() {
        val result = SUT.foo(1,2)

        Assert.assertThat(result, CoreMatchers.`is`(3))
    }
}