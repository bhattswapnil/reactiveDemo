package com.example.reacitvespring.reacitvespring.person.service

import com.example.reacitvespring.reacitvespring.Bundle
import com.example.reacitvespring.reacitvespring.BundleEntry
import com.example.reacitvespring.reacitvespring.Reference
import com.example.reacitvespring.reacitvespring.organization.model.DTDOrganization
import com.example.reacitvespring.reacitvespring.organization.repository.OrganizationRepository
import com.example.reacitvespring.reacitvespring.person.model.PersonDTO
import com.example.reacitvespring.reacitvespring.person.repository.PersonRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@Service
class PersonServiceImpl(
        val personRepository: PersonRepository,
        val referenceOrganization: Reference<DTDOrganization>,
        val organizationRepository: OrganizationRepository
): PersonService {

    override fun findAll(): Flux<PersonDTO> {
        return personRepository.findAll()   //limit rate to achieve back pressure
    }


    override  fun readResource(id: String): Mono<PersonDTO> {
        return personRepository.findOneById(id)
       }

    override fun createPerson(personDTO: PersonDTO): Mono<PersonDTO> {
        val id: String = ObjectId().toString();
        toReference(personDTO);
        //createFullName(personDTO);
        return personRepository.save(PersonDTO(
                id = id,
                name = personDTO.name,
                birthDate = personDTO.birthDate,
                gender = personDTO.gender,
                address = personDTO.address,
                managingOrganization = referenceOrganization
        ))
    }

    fun toReference(Person: PersonDTO) {
        val organizationId = Person.managingOrganization?.identifier?.value;
        referenceOrganization.identifier = Person.managingOrganization?.identifier;
        referenceOrganization.type = Person.managingOrganization?.type;
        referenceOrganization.reference = "/Organization/${organizationId}";
    }

    fun createFullName(Person: PersonDTO){
            for(humanName in Person.name!!)
                for(lastName in humanName.given!!) {
                    val fullName = lastName + humanName.family
                    humanName.text = fullName.toLowerCase()
                }
        }
}