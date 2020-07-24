package com.example.reacitvespring.reacitvespring.controller

import com.example.reacitvespring.reacitvespring.model.PersonDTO
import com.example.reacitvespring.reacitvespring.service.PersonService
import org.reactivestreams.Publisher
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.Flow

@RestController
@RequestMapping("/person1")
class PersonController(
        val personService: PersonService
) {

    @GetMapping
    fun getAllPersons(): Flux<PersonDTO> {
    return personService.findAll().log()
    }

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable("id")id:String):Mono<ResponseEntity<PersonDTO>> {
        return personService.findById(id).map { person -> ResponseEntity<PersonDTO>(person,HttpStatus.OK) }.log()
    }

    @PostMapping
    fun createPerson(@RequestBody personDTO: PersonDTO): Mono<PersonDTO>{
        return personService.createPerson(personDTO).log()
    }

    @PutMapping("/{id}")
    fun updatePerson(@RequestBody personDTO: PersonDTO , @PathVariable id: String): Mono<PersonDTO>{
        return personService.findById(id)
                .flatMap { personService.createPerson(personDTO)}.log()
    }

}