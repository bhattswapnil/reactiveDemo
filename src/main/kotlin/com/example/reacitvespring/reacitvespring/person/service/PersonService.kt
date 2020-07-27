package com.example.reacitvespring.reacitvespring.person.service

import com.example.reacitvespring.reacitvespring.Bundle
import com.example.reacitvespring.reacitvespring.person.model.PersonDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PersonService {

    fun findAll(): Flux<PersonDTO>

    fun readResource(id: String): Mono<PersonDTO>

    fun createPerson(personDTO: PersonDTO): Mono<PersonDTO>

}