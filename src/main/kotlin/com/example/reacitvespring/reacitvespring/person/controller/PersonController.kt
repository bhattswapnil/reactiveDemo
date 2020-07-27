package com.example.reacitvespring.reacitvespring.person.controller

import com.example.reacitvespring.reacitvespring.Response
import com.example.reacitvespring.reacitvespring.person.model.PersonDTO
import com.example.reacitvespring.reacitvespring.person.service.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@RestController
@RequestMapping(value= ["/person"],produces= ["application/stream+json"])
class PersonController(
        val personService: PersonService
) {

    @GetMapping
    fun getAllPersons(): Flux<PersonDTO> {
    return personService.findAll().log().delayElements(Duration.ofSeconds(1))
    }

    @GetMapping("/{id}")
     fun getPersonById(@PathVariable("id")id:String):Mono<PersonDTO> {
        return personService.readResource(id)
    }

    @PostMapping
    fun createPerson(@RequestBody personDTO: PersonDTO): Mono<PersonDTO>{
        return personService.createPerson(personDTO).log()
    }

    @PutMapping("/{id}")
    fun updatePerson(@RequestBody personDTO: PersonDTO, @PathVariable id: String): Mono<PersonDTO>{
        return personService.readResource(id)
                .flatMap { personService.createPerson(personDTO)}.log()
    }

}