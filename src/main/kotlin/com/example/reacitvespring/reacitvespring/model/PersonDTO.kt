package com.example.reacitvespring.reacitvespring.model

import java.time.LocalDate

data class PersonDTO(
        val id :String?= null,
        val name: String? = null,
        val gender: String? = null,
        val birthDate: LocalDate? = null,
        val address: String?= null
){

}