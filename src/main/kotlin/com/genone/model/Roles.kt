package com.genone.model

import io.micronaut.core.annotation.Introspected
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ForeignKey
import javax.persistence.GeneratedValue

@Entity
@Introspected
data class Roles(

    @javax.persistence.Id
    @GeneratedValue
    val id: Long?,

    @Column
    val role: String?,
)