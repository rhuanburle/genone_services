package com.genone.repository

import com.genone.model.ContactEmail
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ContactEmailRepository: JpaRepository<ContactEmail, Long> {
    fun findByEmail(email: String): ContactEmail
    fun findByPhone(phone: String): ContactEmail
    fun findByMessage(message: String): ContactEmail
}
