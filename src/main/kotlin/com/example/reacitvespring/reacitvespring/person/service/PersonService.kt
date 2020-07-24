package com.example.reacitvespring.reacitvespring.service

import com.example.reacitvespring.reacitvespring.model.PersonDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PersonService {

    fun findAll(): Flux<PersonDTO>

    fun findById(id: String) : Mono<PersonDTO>

    fun createPerson(personDTO: PersonDTO): Mono<PersonDTO>

}