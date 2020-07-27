package com.example.reacitvespring.reacitvespring.medication.repository

import com.example.reacitvespring.reacitvespring.DTDMedicationStatement
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface MedicationRepository: ReactiveMongoRepository<DTDMedicationStatement, String> {

    fun findOneById(id: String): Mono<DTDMedicationStatement>

    fun findBySubjectIdentifierValue(personId: String): List<DTDMedicationStatement>?

}