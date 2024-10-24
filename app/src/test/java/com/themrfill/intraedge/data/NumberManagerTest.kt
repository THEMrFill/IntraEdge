package com.themrfill.intraedge.data

import org.junit.Assert.assertEquals
import org.junit.Test

class NumberManagerTest {

    @Test
    fun toDigitsTests() {
        assertEquals("005", NumberManager.toDigits(5, 3))

        assertEquals("025", NumberManager.toDigits(25, 3))

        assertEquals("215", NumberManager.toDigits(215, 3))

        assertEquals("0005", NumberManager.toDigits(5, 4))

        assertEquals("0025", NumberManager.toDigits(25, 4))

        assertEquals("0215", NumberManager.toDigits(215, 4))
    }

    @Test
    fun makeAlphaTest() {
        // do 50 checks to make sure it doesn't break
        for (i in 1..50) {
            when (val result = NumberManager.makeAlpha()) {
                "A", "B", "C", "D" -> assert(true)
                else -> {
                    println("MakeAlpha failed with result=$result")
                    assert(false)
                }
            }
        }
    }
}