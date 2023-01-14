package com.genone.controller

import com.genone.model.Users
import com.genone.repository.UserRepository
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured

@Controller("/user")
class UserController(private val userRepository: UserRepository) {

    @Get
    @Secured("isAnonymous()")
    fun getUser(): List<Users> {
        return userRepository.findAll()
    }

    @Post
    @Secured("isAnonymous()")
    fun addUser(users: Users): Users {
        return userRepository.save(users)
    }

    @Delete
    @Secured("isAnonymous()")
    fun deleteUser(users: Users) {
        userRepository.delete(users)
    }

}