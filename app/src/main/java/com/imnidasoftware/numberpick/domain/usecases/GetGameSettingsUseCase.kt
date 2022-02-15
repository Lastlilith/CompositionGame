package com.imnidasoftware.numberpick.domain.usecases

import com.imnidasoftware.numberpick.domain.entities.GameSettings
import com.imnidasoftware.numberpick.domain.entities.Level
import com.imnidasoftware.numberpick.domain.repository.GameRepository


class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}