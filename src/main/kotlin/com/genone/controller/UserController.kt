package com.genone.controller

import com.genone.model.Users
import com.genone.repository.UserRepository
import com.genone.security.BCryptPasswordEncoderService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import org.springframework.security.crypto.bcrypt.BCrypt

@Controller("/user")
class UserController(private val userRepository: UserRepository, private val bCryptPasswordEncoderService: BCryptPasswordEncoderService) {

    @Get("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured(SecurityRule.IS_AUTHENTICATED)
    fun getUser(): HttpResponse<List<Users>> {
        return HttpResponse.ok(userRepository.findAll())
    }

    @Post("/add")
    @Secured("isAnonymous()")
    fun addUser(users: Users): Users {
        val userCopy = users.copy(password = bCryptPasswordEncoderService.encode(users.password))
        return userRepository.save(userCopy)
    }

    @Delete("/delete")
    @Secured("isAuthenticated()")
    fun deleteUser(users: Users) {
        userRepository.delete(users)
    }

}