package com.example.demo.medication.model

import com.example.demo.Dosage
import com.example.demo.Reference
import com.example.demo.person.model.PersonDTO

class DTDMedicationStatement(
        val id:String?= null,
        val status: String?= null,
        val subject:Reference<PersonDTO>?= null,
        val dosage: Dosage?= null
)