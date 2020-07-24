package com.example.reacitvespring.reacitvespring.service

import com.example.reacitvespring.reacitvespring.model.PersonDTO
import com.example.reacitvespring.reacitvespring.repository.PersonRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PersonServiceImpl(
        val personRepository: PersonRepository
):PersonService{

    override fun findAll(): Flux<PersonDTO> {
        return personRepository.findAll().limitRate(10)        //limit rate to achieve back pressure
    }

    override fun findById(id: String): Mono<PersonDTO> {
       return personRepository.findById(id)
    }

    override fun createPerson(personDTO: PersonDTO): Mono<PersonDTO> {
       return personRepository.save(personDTO)
    }


}