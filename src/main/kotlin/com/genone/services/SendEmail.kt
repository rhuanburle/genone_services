package com.genone.services

import jakarta.inject.Singleton
import io.micronaut.email.EmailSender
import io.micronaut.email.Email
import io.micronaut.email.MultipartBody
import javax.mail.Message
import javax.mail.MessagingException

class SendEmail () {
    @Singleton
    fun sendEmail() {
        println("Aqui")
    }
}