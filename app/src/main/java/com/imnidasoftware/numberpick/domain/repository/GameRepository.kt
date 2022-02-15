package com.imnidasoftware.numberpick.domain.repository

import com.imnidasoftware.numberpick.domain.entities.GameSettings
import com.imnidasoftware.numberpick.domain.entities.Level
import com.imnidasoftware.numberpick.domain.entities.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}