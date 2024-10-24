package com.themrfill.intraedge.data

object NumberManager {
    private const val LETTER_RANGE = "ABCD"
    private const val HYPHEN = "-"

    fun createNewNumber(): String {
        return toDigits((0..999).random(), 3) + HYPHEN +
                makeAlpha() + makeAlpha() + HYPHEN +
                toDigits((0..999).random(), 3)
    }

    fun toDigits(number: Int, len: Int): String {
        val extra = len - number.toString().length
        if (extra <= 0)
            return number.toString()
        val zeroes = "0".repeat(extra)
        return zeroes + number.toString()
    }

    fun makeAlpha(): String {
        val rand = LETTER_RANGE.indices.random()
        return LETTER_RANGE[rand].toString()
    }
}