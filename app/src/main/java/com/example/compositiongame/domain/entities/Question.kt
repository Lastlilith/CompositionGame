package com.example.compositiongame.domain.entities

data class Question (
    val sum: Int,
    val visibleNumber: Int,
    val options: List<Int>
)