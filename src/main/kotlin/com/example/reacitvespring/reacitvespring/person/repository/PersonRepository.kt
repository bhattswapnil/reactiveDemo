package com.example.reacitvespring.reacitvespring.person.repository

import com.example.reacitvespring.reacitvespring.person.model.PersonDTO
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface PersonRepository: ReactiveMongoRepository<PersonDTO,String>{

    fun findOneById(id: String): Mono<PersonDTO>


}