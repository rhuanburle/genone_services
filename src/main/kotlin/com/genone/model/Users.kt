package com.genone.model
import io.micronaut.core.annotation.Introspected
import javax.persistence.*

@Entity
@Introspected
data class Users (
    @Id
    @GeneratedValue
    val id: Long?,
    @Column
    val name: String,
    @Column
    val email: String,
    @Column
    val password: String,
    @Column
    val dateCreated: String,
    @Column
    val dateUpdated: String?,
)