package com.example.reacitvespring.reacitvespring.person.model

import com.example.reacitvespring.reacitvespring.Address
import com.example.reacitvespring.reacitvespring.DomainResource
import com.example.reacitvespring.reacitvespring.HumanName
import com.example.reacitvespring.reacitvespring.Reference
import com.example.reacitvespring.reacitvespring.organization.model.DTDOrganization
import com.fasterxml.jackson.annotation.JsonIgnore
import org.jetbrains.annotations.NotNull
import java.time.LocalDate

data class PersonDTO(
        @JsonIgnore var id: String? = null,
        val name: MutableSet<HumanName>?= null,
        @JsonIgnore var gender: String?= null,
        @JsonIgnore var birthDate: LocalDate? = null,
        @JsonIgnore val address: MutableSet<Address>?= null,
        @JsonIgnore val managingOrganization: Reference<DTDOrganization>? = null
): DomainResource(){

}