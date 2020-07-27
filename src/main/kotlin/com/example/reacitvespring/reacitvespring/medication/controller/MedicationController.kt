package com.example.reacitvespring.reacitvespring.medication.controller

import com.example.reacitvespring.reacitvespring.DTDMedicationStatement
import com.example.reacitvespring.reacitvespring.medication.service.MedicationService
import com.example.reacitvespring.reacitvespring.organization.model.DTDOrganization
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/medication")
class MedicationController(
        private val medicationService: MedicationService
){

    @GetMapping
    fun getAllMedication(): Flux<DTDMedicationStatement> {
        return medicationService.findAll().log()
    }
    @GetMapping("/{id}")
    fun getMedicationById(@PathVariable("id")id:String):Mono<DTDMedicationStatement> {
        return medicationService.readResource(id)
    }

    @PutMapping("/{id}")
    fun updatePerson(@RequestBody dtdMedicationStatement: DTDMedicationStatement, @PathVariable id: String): Mono<DTDMedicationStatement>{
        return medicationService.readResource(id)
                .flatMap { medicationService.createResource(dtdMedicationStatement)}.log()
    }

    @PostMapping
    fun createMedication(@RequestBody request: DTDMedicationStatement): Mono<DTDMedicationStatement> {
        return medicationService.createResource(request)
    }

}
