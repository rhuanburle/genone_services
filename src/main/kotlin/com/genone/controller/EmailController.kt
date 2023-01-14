package com.genone.controller

import com.genone.services.SendEmail
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import javax.mail.Message


@Controller("/email")
class EmailController {

    @Get("/send")
    @Secured("isAnonymous()")
    fun sendEmail() {
        SendEmail("email").sendEmail()
    }
}