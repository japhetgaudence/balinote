package com.balitech.balinote.domain.models.common

import androidx.annotation.StringRes
import com.balitech.balinote.R

sealed class Priority(@StringRes val uiValue: Int, dbValue: String) {

    data object Urgent: Priority(
        uiValue = R.string.priority_urgent,
        dbValue = "URGENT"
    )

    data object High: Priority(
        uiValue = R.string.priority_high,
        dbValue = "HIGH"
    )

    data object Medium: Priority(
        uiValue = R.string.priority_medium,
        dbValue = "MEDIUM"
    )

    data object Low: Priority(
        uiValue = R.string.priority_low,
        dbValue = "LOW"
    )

    data object None: Priority(
        uiValue = R.string.priority_none,
        dbValue = "NONE"
    )
}