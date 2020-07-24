package com.example.demo.medication.controller

import com.example.demo.medication.model.DTDMedicationStatement
import com.example.demo.medication.service.MedicationService
import com.example.demo.organization.model.DTDOrganization
import com.example.demo.person.model.PersonDTO
import com.example.demo.person.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/medication")
class MedicationController(
        private val medicationService: MedicationService
){
    @GetMapping
    fun getAllMedications(): ResponseEntity<List<DTDMedicationStatement>> {
        val medication = medicationService.getResources()
        return ResponseEntity.ok(medication)
    }

    @PutMapping("/{id}")
    fun updatePerson(@RequestBody request: DTDMedicationStatement, @PathVariable("id")id: String) : ResponseEntity<DTDMedicationStatement> {
        val medication = medicationService.updateResource(request,id)
        return ResponseEntity(medication, HttpStatus.OK)
    }

    @PostMapping
    fun createMedication(@RequestBody request: DTDMedicationStatement): ResponseEntity<DTDMedicationStatement> {
        val medication = medicationService.createResource(request)
        return ResponseEntity(medication, HttpStatus.CREATED)
    }

}
