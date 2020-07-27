package com.example.reacitvespring.reacitvespring.organization.service

import com.example.reacitvespring.reacitvespring.organization.model.DTDOrganization
import com.example.reacitvespring.reacitvespring.person.model.PersonDTO
import reactor.core.publisher.Flux

import reactor.core.publisher.Mono

interface OrganizationService{

    fun createOrganization(dtdOrganization: DTDOrganization): Mono<DTDOrganization>

    fun readResource(id: String): Mono<DTDOrganization>

    fun findAll(): Flux<DTDOrganization>
}