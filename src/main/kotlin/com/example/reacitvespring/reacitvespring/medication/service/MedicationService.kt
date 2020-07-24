package com.example.demo.medication.service

import com.example.demo.medication.model.DTDMedicationStatement

interface MedicationService {

    fun getResources(): List<DTDMedicationStatement>

    fun createResource(medication: DTDMedicationStatement): DTDMedicationStatement

    fun updateResource(medication: DTDMedicationStatement ,id:String): DTDMedicationStatement
}