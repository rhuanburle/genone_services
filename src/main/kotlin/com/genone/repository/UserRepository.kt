package com.genone.repository

import com.genone.model.Users
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
@Repository
interface UserRepository: JpaRepository<Users, Long> {

}