package com.example.reacitvespring.reacitvespring.repository

import com.example.reacitvespring.reacitvespring.model.PersonDTO
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PersonRepository: ReactiveMongoRepository<PersonDTO,String>{
}