package com.example.reacitvespring.reacitvespring.organization.model

import com.example.reacitvespring.reacitvespring.Address
import com.example.reacitvespring.reacitvespring.DomainResource


data class DTDOrganization(

        var id: String?= null,
        var name: String? = null,
        var address: MutableSet<Address>? = null
): DomainResource(){

}