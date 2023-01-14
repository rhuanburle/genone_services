package com.genone.services

import jakarta.inject.Singleton
import io.micronaut.email.EmailSender
import io.micronaut.email.Email
import io.micronaut.email.MultipartBody
import javax.mail.Message
import javax.mail.MessagingException

class SendEmail (private val emailSender: EmailSender<Message, *>) {
    @Singleton
    fun sendEmail() {
       emailSender.send(
              Email
                .builder()
                .subject("Micronaut Email")
                  .from("sender@example.com")
                  .to("rhuanburlerb@gmail.com")
                        .body(MultipartBody("<html><body><strong>Hello</strong> dear Micronaut user.</body></html>", "Hello dear Micronaut user")))
        println("Aqui")
    }
}