package com.example.demo.medication.repository

import com.example.demo.medication.model.DTDMedicationStatement
import com.example.demo.person.model.PersonDTO
import org.springframework.data.mongodb.repository.MongoRepository

interface MedicationRepository: MongoRepository<DTDMedicationStatement, String> {

    fun findOneById(id: String): DTDMedicationStatement

    fun findBySubjectIdentifierValue(personId: String): List<DTDMedicationStatement>?

}