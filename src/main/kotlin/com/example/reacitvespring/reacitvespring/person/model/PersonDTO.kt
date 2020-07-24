package com.example.reacitvespring.reacitvespring.model

import com.example.demo.Address
import com.example.demo.DomainResource
import com.example.demo.HumanName
import com.example.demo.Reference
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
data class PersonDTO(
        val id: String? = null,
        @NotNull("Name required")
    val name: MutableSet<HumanName>,
        val gender: String?= null,
        @NotNull("Birthdate Required")
    val birthDate: LocalDate,
        @NotNull("address required")
    val address: MutableSet<Address>,
        val managingOrganization: Reference<DTDOrganization>? = null
): DomainResource(){

}