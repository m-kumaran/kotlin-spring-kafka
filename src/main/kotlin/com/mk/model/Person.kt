package com.mk.model

import java.time.ZonedDateTime
import java.util.UUID

data class Person(val id: UUID, val email: String, val inTime: ZonedDateTime= ZonedDateTime.now())
