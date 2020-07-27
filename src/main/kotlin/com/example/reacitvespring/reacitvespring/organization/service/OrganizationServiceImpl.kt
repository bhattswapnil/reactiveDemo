package com.example.reacitvespring.reacitvespring.organization.service

import com.example.reacitvespring.reacitvespring.organization.model.DTDOrganization
import com.example.reacitvespring.reacitvespring.organization.repository.OrganizationRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class OrganizationServiceImpl(
        val organizationRepository: OrganizationRepository

):OrganizationService {

    override fun createOrganization(dtdOrganization: DTDOrganization): Mono<DTDOrganization> {
        val id: String = ObjectId().toString();
        return organizationRepository.save(DTDOrganization(
                id = id,
                name = dtdOrganization.name,
                address = dtdOrganization.address
        ))
    }

    override fun readResource(id: String): Mono<DTDOrganization> {
        return organizationRepository.findOneById(id)
    }

    override fun findAll(): Flux<DTDOrganization> {
        return organizationRepository.findAll()
    }
}