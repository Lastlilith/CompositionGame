package com.imnidasoftware.numberpick.domain.entities

data class Question (
    val sum: Int,
    val visibleNumber: Int,
    val options: List<Int>
) {


    val rightAnswer: Int
    get() = sum - visibleNumber
}