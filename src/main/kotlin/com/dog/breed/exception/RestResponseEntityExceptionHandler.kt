package com.dog.breed.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [IllegalArgumentException::class, IllegalStateException::class,
        HttpClientErrorException.BadRequest ::class, HttpClientErrorException.BadRequest::class,
        HttpClientErrorException.Forbidden::class])
    protected fun handleConflict(
        ex: java.lang.Exception, request: WebRequest
    ): ResponseEntity<Any> {
        val bodyOfResponse = "Error Response"
        return handleExceptionInternal(
            ex, bodyOfResponse,
            HttpHeaders(), HttpStatus.CONFLICT, request
        )
    }

    //Done: FIXME: it does not compile
}