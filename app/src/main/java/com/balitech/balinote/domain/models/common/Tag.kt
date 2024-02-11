package com.balitech.balinote.domain.models.common

import java.time.LocalDateTime

data class Tag(
    val id: String = "",
    val name: String = "",
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val createdAt: LocalDateTime = LocalDateTime.now(),
)