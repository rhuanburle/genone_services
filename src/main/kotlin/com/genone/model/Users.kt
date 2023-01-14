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
    @Column
    val phone: String,
    @Column
    val streetAddress: String,
    @Column
    val city: String,
    @Column
    val state: String,
    @Column
    val zipCode: String,
)
