package com.balitech.balinote.domain.models.common

import androidx.annotation.StringRes
import com.balitech.balinote.R

sealed class Status(@StringRes val uiValue: Int, dbValue: String) {

    data object Created: Status(
        uiValue = R.string.status_created,
        dbValue = "CREATED"
    )

    data object InProgress: Status(
        uiValue = R.string.status_in_progress,
        dbValue = "IN PROGRESS"
    )

    data object Paused: Status(
        uiValue = R.string.status_paused,
        dbValue = "PAUSED"
    )

    data object Completed: Status(
        uiValue = R.string.status_completed,
        dbValue = "COMPLETED"
    )
}