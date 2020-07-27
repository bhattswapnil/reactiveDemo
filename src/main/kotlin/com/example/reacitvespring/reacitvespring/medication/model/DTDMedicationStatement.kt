package com.example.reacitvespring.reacitvespring

import com.example.reacitvespring.reacitvespring.person.model.PersonDTO


class DTDMedicationStatement(
        val id:String?= null,
        val status: String?= null,
        val subject:Reference<PersonDTO>?= null,
        val dosage: Dosage?= null
)