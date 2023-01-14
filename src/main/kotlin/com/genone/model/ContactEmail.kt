package com.genone.model

import io.micronaut.core.annotation.Introspected
import javax.persistence.*

@Entity
@Introspected
class ContactEmail (
    @Id
    @GeneratedValue
    val id: Long?,
    @Column
    val name: String?,
    @Column
    val email: String?,
    @Column
    val phone: String?,
    @Column
    val subject: String?,
    @Column
    val message: String?,
    @Column
    val sendDate: String?
)
