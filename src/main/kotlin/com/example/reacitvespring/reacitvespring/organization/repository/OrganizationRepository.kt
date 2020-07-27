package com.example.reacitvespring.reacitvespring.organization.repository

import com.example.reacitvespring.reacitvespring.organization.model.DTDOrganization
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface OrganizationRepository : ReactiveMongoRepository<DTDOrganization, String> {

    fun findOneById(id:String): Mono<DTDOrganization>
}