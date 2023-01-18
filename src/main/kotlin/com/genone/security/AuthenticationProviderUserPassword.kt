package com.genone.security

import com.genone.repository.UserRepository
import io.micronaut.core.async.publisher.Publishers
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.*
import io.reactivex.rxjava3.core.Flowable
import jakarta.inject.Singleton
import org.reactivestreams.Publisher
import org.springframework.security.crypto.password.PasswordEncoder


@Singleton
class AuthenticationProviderUserPassword(private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder) : AuthenticationProvider {

    override fun authenticate(
        httpRequest: HttpRequest<*>?,
        authenticationRequest: AuthenticationRequest<*, *>?
    ): Publisher<AuthenticationResponse>? {

        var user = userRepository.findByEmail(
            authenticationRequest?.identity.toString(),
        )

        if (user == null) {
            throw AuthenticationException(AuthenticationFailed("Pessoa não encontrada com e-mail: ${authenticationRequest?.identity} informado."))
        }

        if (!passwordEncoder.matches(authenticationRequest?.secret.toString(), user.password)) {
            throw AuthenticationException(AuthenticationFailed("Senha incorreta."))
        }
        return Publishers.just(AuthenticationResponse.success(user.name))
//        return Flowable.just(AuthenticationResponse.success(user.name))
    }
}