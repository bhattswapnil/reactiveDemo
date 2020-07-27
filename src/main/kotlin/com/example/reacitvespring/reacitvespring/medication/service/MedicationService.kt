package com.example.reacitvespring.reacitvespring.medication.service

import com.example.reacitvespring.reacitvespring.DTDMedicationStatement
import com.example.reacitvespring.reacitvespring.organization.model.DTDOrganization
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface MedicationService {

    fun readResource(id: String): Mono<DTDMedicationStatement>

    fun createResource(medication: DTDMedicationStatement): Mono<DTDMedicationStatement>

    //fun updateResource(medication: DTDMedicationStatement ,id:String): DTDMedicationStatement

    fun findAll(): Flux<DTDMedicationStatement>
}