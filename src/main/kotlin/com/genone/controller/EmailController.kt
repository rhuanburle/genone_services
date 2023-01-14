package com.genone.controller

import com.genone.model.ContactEmail
import com.genone.repository.ContactEmailRepository
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured


@Controller("/email")
@Secured("isAnonymous()")
class EmailController (private val contactEmailRepository: ContactEmailRepository) {

    @Post("/send")
    @Secured("isAnonymous()")
    fun addContact(contactEmail: ContactEmail): ContactEmail {
        return contactEmailRepository.save(contactEmail)
    }

    @Get("/all")
    @Secured("isAnonymous()")
    fun getAllContact(): List<ContactEmail> {
        return contactEmailRepository.findAll()
    }
}