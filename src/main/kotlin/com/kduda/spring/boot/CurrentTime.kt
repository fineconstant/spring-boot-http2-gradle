package com.kduda.spring.boot

import java.time.Instant
import java.util.*

data class CurrentTime(
    val currentTime: Instant = Instant.now(),
    val timezone: TimeZone = TimeZone.getDefault()
)
