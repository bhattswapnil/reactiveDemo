package com.example.reacitvespring.reacitvespring.organization.controller

import com.example.reacitvespring.reacitvespring.organization.model.DTDOrganization
import com.example.reacitvespring.reacitvespring.organization.service.OrganizationService
import com.example.reacitvespring.reacitvespring.person.model.PersonDTO
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/Organization")
class OrganizationController(
        val organizationService: OrganizationService
) {

    @GetMapping
    fun getAllOrganization(): Flux<DTDOrganization> {
        return organizationService.findAll().log()
    }

    @GetMapping("/{id}")
    fun getOrganizationById(@PathVariable("id")id:String):Mono<DTDOrganization> {
        return organizationService.readResource(id)
    }
    @PostMapping
    fun createOrganization(@RequestBody request: DTDOrganization): Mono<DTDOrganization> {
        return organizationService.createOrganization(request).log()
    }

    @PutMapping("/{id}")
    fun updatePerson(@RequestBody dtdOrganization: DTDOrganization, @PathVariable id: String): Mono<DTDOrganization>{
        return organizationService.readResource(id)
                .flatMap { organizationService.createOrganization(dtdOrganization)}.log()
    }
}