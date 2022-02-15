package com.imnidasoftware.numberpick.domain.usecases

import com.imnidasoftware.numberpick.domain.entities.Question
import com.imnidasoftware.numberpick.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object {
        private const val COUNT_OF_OPTIONS = 6
    }
}